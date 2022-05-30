package com.adidas.shoetracing.config;

import com.adidas.shoetracing.blockchain.model.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

@Configuration
public class DeploymentBean {

    @Autowired
    Web3j web3J;
    @Autowired
    Credentials credentials;
    @Autowired
    ContractGasProvider  contractGasProvider;

    @Value("${eth.chainId}")
    String chainId;


    @Bean
    RawTransactionManager txManager() {
        return new RawTransactionManager(web3J, credentials, Long.parseLong(chainId));
    }

    @Bean()
    HelloWorld deployContract() throws Exception {
        System.out.println("Deploying Smart Contract");
        HelloWorld helloWorld = HelloWorld.deploy(web3J, txManager(), contractGasProvider, "HelloWorld").send();
        return helloWorld;
    }


}
