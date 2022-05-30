package com.adidas.shoetracing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

@Configuration
public class InitializationBean {

    @Value("${eth.endpoint}")
    String endpoint;

    @Value("${eth.privateKey}")
    String privKey;

    @Bean
    Web3j web3J() {
        return Web3j.build(new HttpService(endpoint));
    }

    @Bean
    Credentials crededentials() {
        return Credentials.create(privKey);
    }

    @Bean
    ContractGasProvider gasProvider() {
        return new StaticGasProvider(new BigInteger("20000000000"), new BigInteger("6721975"));
    }
}
