package com.adidas.shoetracing.api;

import com.adidas.shoetracing.model.ProductInformation;
import com.adidas.shoetracing.service.ProductService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
      String data = "http://localhost:3000/landing/"+tokenId;
      String fileName = "src/main/resources/qrcodes/qr_"+tokenId+".png";

      Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
      hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

      int width = 400;
      int height = 400;

      QRCodeWriter qrCodeWriter = new QRCodeWriter();
      BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height, hints);
      Path filePath = Paths.get(fileName);
      MatrixToImageWriter.writeToPath(bitMatrix, "PNG", filePath);

      ClassLoader classLoader = getClass().getClassLoader();
      File file = new File(fileName);
      InputStream in = new FileInputStream(file);

      return ResponseEntity.ok(IOUtils.toByteArray(in));
    } catch (IOException | WriterException e) {
      e.printStackTrace();
    }
    return ResponseEntity.internalServerError().build();
  }
}
