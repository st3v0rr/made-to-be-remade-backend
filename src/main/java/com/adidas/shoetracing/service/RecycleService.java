package com.adidas.shoetracing.service;

import com.adidas.shoetracing.blockchain.model.APN;
import com.adidas.shoetracing.model.RecyclingRequest;
import io.reactivex.Maybe;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class RecycleService {

    private final APN contractAddress;
    private final Web3j web3j;
    private final Credentials credentials;


    public RecycleService(APN contractAddress, Web3j web3j, Credentials credentials) {
        this.contractAddress = contractAddress;
        this.web3j = web3j;
        this.credentials = credentials;
    }

    public void recycleItem(String id, RecyclingRequest recyclingRequest) {
        try {
            BigInteger tokenId = BigInteger.valueOf(Long.parseLong(id));

            String ownerAddress = contractAddress.ownerOf(tokenId).send();

            contractAddress.approve(contractAddress.getContractAddress(), tokenId).send();
            contractAddress.burn(tokenId).send();

            BigInteger value = Convert.toWei("1.0", Convert.Unit.ETHER).toBigInteger();
            TransactionReceipt transactionReceipt = Transfer.sendFunds(web3j, credentials, recyclingRequest.getToAddress(),
                    BigDecimal.valueOf(1.0), Convert.Unit.ETHER).send();

        } catch (
                Exception e) {

        }


    }
}
