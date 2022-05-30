package com.adidas.shoetracing;

import com.adidas.shoetracing.api.ShoeInformationApi;
import com.adidas.shoetracing.model.ShoeInformation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoeInformationController implements ShoeInformationApi {

    @Override
    public ResponseEntity<ShoeInformation> retrieveMessage(String id) {
        ShoeInformation shoeInformation = new ShoeInformation();
        shoeInformation.setDescription("abc");
        return ResponseEntity.ok(shoeInformation);
    }
    
}
