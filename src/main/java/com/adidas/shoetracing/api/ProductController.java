package com.adidas.shoetracing.api;

import com.adidas.shoetracing.model.ProductInformation;
import com.adidas.shoetracing.service.ProductService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductController implements ProductApi{

  private final ProductService productService;
  private final ServletContext servletContext;

  public ProductController(ProductService productService, ServletContext servletContext) {
    this.productService = productService;
    this.servletContext = servletContext;
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
  public ResponseEntity<byte[]> buyProduct(ProductInformation productInformation) {
    String tokenId = productService.buyProduct(productInformation);

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("qrcodes/asdasdas.jpeg").getFile());
    InputStream in = null;
    try {
      in = new FileInputStream(file);
      return ResponseEntity.ok(IOUtils.toByteArray(in));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ResponseEntity.internalServerError().build();
  }
}
