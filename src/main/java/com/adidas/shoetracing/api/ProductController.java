package com.adidas.shoetracing.api;

import com.adidas.shoetracing.model.ProductInformation;
import com.adidas.shoetracing.service.ProductService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    try {
      String data = "http://localhost:3000/landing?tokenId="+tokenId;
      String path = "qrcodes/qr_"+tokenId+".png";
      String charset = "UTF-8";

      Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();
      hashMap.put(EncodeHintType.ERROR_CORRECTION,
          ErrorCorrectionLevel.L);

      BitMatrix matrix = new MultiFormatWriter().encode(
          new String(data.getBytes(charset), charset),
          BarcodeFormat.QR_CODE, 400, 400, hashMap);

      MatrixToImageWriter.writeToFile(
          matrix,
          path.substring(path.lastIndexOf('.') + 1),
          new File(path));

      ClassLoader classLoader = getClass().getClassLoader();
      File file = new File(Objects.requireNonNull(classLoader.getResource(path)).getFile());
      InputStream in = new FileInputStream(file);

      return ResponseEntity.ok(IOUtils.toByteArray(in));
    } catch (IOException | WriterException e) {
      e.printStackTrace();
    }
    return ResponseEntity.internalServerError().build();
  }
}
