package com.adidas.shoetracing.service;

import com.adidas.shoetracing.model.ProductInformation;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  public String buyProduct(ProductInformation productInformation) { //return String is tokenId
    //Mint product
    //Transfer product (from owner adidas to buyer)
    return "";
  }

  public ProductInformation getProduct(String tokenId) {
    //Load contract information and map
    return new ProductInformation();
  }

  public List<ProductInformation> getOwnerProducts(String ownerAdress) {
    //Load NFTs of owner
    return Collections.emptyList();
  }

  public List<ProductInformation> getAllProducts() {
    //Load all available NFTs on contract
    return Collections.emptyList();
  }

}
