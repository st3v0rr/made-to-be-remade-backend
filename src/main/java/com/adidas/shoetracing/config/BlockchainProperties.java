package com.adidas.shoetracing.config;

import java.math.BigInteger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "blockchain")
public class BlockchainProperties {

  private String endpoint;
  private String privateKey;
  private Long chainId;
  private BigInteger gasPrice;
  private BigInteger gasLimit;

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getPrivateKey() {
    return privateKey;
  }

  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }

  public Long getChainId() {
    return chainId;
  }

  public void setChainId(Long chainId) {
    this.chainId = chainId;
  }

  public BigInteger getGasPrice() {
    return gasPrice;
  }

  public void setGasPrice(BigInteger gasPrice) {
    this.gasPrice = gasPrice;
  }

  public BigInteger getGasLimit() {
    return gasLimit;
  }

  public void setGasLimit(BigInteger gasLimit) {
    this.gasLimit = gasLimit;
  }
}
