package com.adidas.shoetracing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

@Configuration
public class BlockchainConfiguration {

    private final BlockchainProperties blockchainProperties;

    public BlockchainConfiguration(BlockchainProperties blockchainProperties) {
        this.blockchainProperties = blockchainProperties;
    }

    @Bean
    Web3j web3J() {
        return Web3j.build(new HttpService(blockchainProperties.getEndpoint()));
    }

    @Bean
    Credentials crededentials() {
        return Credentials.create(blockchainProperties.getPrivateKey());
    }

    @Bean
    ContractGasProvider gasProvider() {
        return new StaticGasProvider(blockchainProperties.getGasPrice(), blockchainProperties.getGasLimit());
    }

    @Bean
    RawTransactionManager txManager(Web3j web3J, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RawTransactionManager(web3J, credentials, blockchainProperties.getChainId());
    }

}
