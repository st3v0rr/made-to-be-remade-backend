package com.adidas.shoetracing.service;

import com.adidas.shoetracing.api.ProductMock;
import com.adidas.shoetracing.blockchain.model.APN;
import com.adidas.shoetracing.dto.IPFSProduct;
import com.adidas.shoetracing.model.ProductInformation;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.exceptions.ContractCallException;

@Service
public class ProductService {

    private final APN productContract;
    private final IPFS ipfs;
    private final String tokenNotFound = "Contract Call has been reverted by the EVM with the reason: 'VM Exception while processing transaction: revert ERC721: owner query for nonexistent token'.";

    private final ObjectMapper objectMapper;

    public ProductService(APN productContract, IPFS ipfs, ObjectMapper objectMapper) {
        this.productContract = productContract;
        this.ipfs = ipfs;
        this.objectMapper = objectMapper;
    }

    public String buyProduct(ProductInformation productInformation) { //return String is tokenId
        //Mint product
        try {
            IPFSProduct product = new IPFSProduct();
            product.setProductId(productInformation.getId());
            product.setName(productInformation.getName());
            product.setDescription(productInformation.getDescription());
            product.setPrice(productInformation.getPrice());
            String productAsString = objectMapper.writeValueAsString(product);

            NamedStreamable.ByteArrayWrapper metadata = new NamedStreamable.ByteArrayWrapper(productAsString.getBytes(StandardCharsets.UTF_8));
            MerkleNode result = ipfs.add(metadata).get(0);

            TransactionReceipt sendTransaction = productContract.safeMint(productInformation.getOwnerAdress(), String.valueOf(result.hash)).send();
            List<APN.TransferEventResponse> transferEvents = productContract.getTransferEvents(sendTransaction);
            BigInteger tokenId = transferEvents.get(0).tokenId;
            System.out.println("Minting nft with id:" + tokenId + " under url " + result.hash);
            return String.valueOf(tokenId);

        } catch (Exception e) {
            return null;
        }
    }

    public ProductInformation getProduct(String tokenId) {
        try {
            BigInteger id = BigInteger.valueOf(Long.parseLong(tokenId));
            String owner = productContract.ownerOf(id).send();
            String uri = productContract.tokenURI(id).send();

            ProductInformation productInformation = new ProductInformation();
            productInformation.setId(tokenId);
            productInformation.setOwner(owner);
            productInformation.setOwnerAdress(owner);

            Multihash filePointer = Multihash.fromBase58(uri);
            byte[] fileContents = ipfs.cat(filePointer);
            String metadata = new String(fileContents, StandardCharsets.UTF_8);

            IPFSProduct product = objectMapper.readValue(metadata, IPFSProduct.class);
            ProductInformation productInformationFromStore = ProductMock.getMockProducts()
                .stream()
                .filter(mockProduct -> mockProduct.getId().equals(product.getProductId()))
                .findFirst().orElseThrow(RuntimeException::new);
            productInformation.setId(productInformationFromStore.getId());
            productInformation.setImageUrl(productInformationFromStore.getImageUrl());
            productInformation.setName(product.getName());
            productInformation.setDescription(product.getDescription());
            productInformation.setPrice(product.getPrice());

            return productInformation;
        } catch (ContractCallException callException) {
            if (callException.getMessage().equals(tokenNotFound)) return null;
        } catch (Exception stateException) {
            return null;
        }
        return null;
    }

    public List<ProductInformation> getOwnerProducts(String ownerAdress) {
        try {
            BigInteger numberOfNfts = productContract.balanceOf(ownerAdress).send();
            int startIndex = 0;
            ArrayList<ProductInformation> nfts = new ArrayList<>();
            do {
                BigInteger id = BigInteger.valueOf(startIndex);
                String owner = productContract.ownerOf(id).send();

                if (owner != null && owner.equalsIgnoreCase(ownerAdress)) {
                    nfts.add(this.getProduct(String.valueOf(id)));
                } else if (owner == null) break;

                startIndex++;


            } while (nfts.size() != numberOfNfts.intValue());
            return nfts;

        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<ProductInformation> getAllProducts() {
        //Load all available NFTs on contract
        return Collections.emptyList();
    }

}
