package com.adidas.shoetracing.api;

import com.adidas.shoetracing.model.ProductInformation;
import com.adidas.shoetracing.service.ProductService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductApi{

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public ResponseEntity<List<ProductInformation>> getProducts() {
    return ResponseEntity.ok(ProductMock.getMockProducts());
  }

  @Override
  public ResponseEntity<ProductInformation> getProduct(String id) {
    return ResponseEntity.ok(productService.getProduct(id));
  }

  @Override
  public ResponseEntity<ProductInformation> buyProduct(ProductInformation productInformation) {

    return ProductApi.super.buyProduct(productInformation);
  }
}
