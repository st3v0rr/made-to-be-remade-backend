package com.adidas.shoetracing.config;


import com.adidas.shoetracing.blockchain.model.APN;
import io.ipfs.api.IPFS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

@Configuration
public class BlockchainDeployment {


    private final Web3j web3j;
    private final TransactionManager transactionManager;
    private final ContractGasProvider contractGasProvider;
    private final BlockchainProperties blockchainProperties;

    public BlockchainDeployment(Web3j web3j, RawTransactionManager transactionManager, ContractGasProvider contractGasProvider, BlockchainProperties blockchainProperties) {
        this.web3j = web3j;
        this.transactionManager = transactionManager;
        this.contractGasProvider = contractGasProvider;
        this.blockchainProperties = blockchainProperties;
    }

    @Bean
    IPFS ipfsConnection() {
        IPFS ipfs = new IPFS(blockchainProperties.getIpfsAddress());
        return ipfs;
    }

    @Bean()
    APN deployNFT() throws Exception {
        System.out.println("Deploy contract");

        if (blockchainProperties.getContractAddress().isBlank())
            return APN.deploy(web3j, transactionManager, contractGasProvider).send();
        System.out.println("Load existing contract");
        return APN.load(blockchainProperties.getContractAddress(), web3j, transactionManager, contractGasProvider);
    }
}
