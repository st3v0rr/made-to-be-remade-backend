package com.adidas.shoetracing.api;

import com.adidas.shoetracing.model.ProductInformation;
import com.adidas.shoetracing.model.RecyclingRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class RecycablesController implements RecycablesApi{


    @Override
    public ResponseEntity<List<ProductInformation>> getRecycableProducts() {
        return RecycablesApi.super.getRecycableProducts();
    }

    @Override
    public ResponseEntity<String> recycleProduct(String id, RecyclingRequest recyclingRequest) {
        return RecycablesApi.super.recycleProduct(id, recyclingRequest);
    }
}
