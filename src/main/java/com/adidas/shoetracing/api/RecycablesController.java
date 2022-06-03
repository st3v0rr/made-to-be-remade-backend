package com.adidas.shoetracing.api;

import com.adidas.shoetracing.model.ProductInformation;
import com.adidas.shoetracing.model.RecyclingRequest;
import com.adidas.shoetracing.service.ProductService;
import com.adidas.shoetracing.service.RecycleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecycablesController implements RecycablesApi {


    private final ProductService productService;
    private final RecycleService recycleService;


    public RecycablesController(ProductService productService, RecycleService recycleService) {
        this.productService = productService;
        this.recycleService = recycleService;
    }

    @Override
    public ResponseEntity<List<ProductInformation>> getRecycableProducts(String ownerAddress) {
        return ResponseEntity.ok(productService.getOwnerProducts(ownerAddress));
    }

    @Override
    public ResponseEntity<String> recycleProduct(String id, RecyclingRequest recyclingRequest) {

        ProductInformation product = productService.getProduct(id);
        if (product == null) return ResponseEntity.notFound().build();

        recycleService.recycleItem(id, recyclingRequest);

        return ResponseEntity.ok("Transfer Happpened");

    }
}
