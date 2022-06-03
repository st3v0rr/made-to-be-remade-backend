package com.adidas.shoetracing;

import com.adidas.shoetracing.model.ProductInformation;
import com.adidas.shoetracing.service.ProductService;
import com.adidas.shoetracing.service.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.math.BigInteger;

@SpringBootApplication
@EnableConfigurationProperties
public class ShoeTracingApplication implements CommandLineRunner {


    @Autowired
    ProductService productService;
    @Autowired
    RecycleService recycleService;

    public static void main(String[] args) {
        SpringApplication.run(ShoeTracingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ProductInformation information = new ProductInformation();
        information.setDescription("This is a very cool sneaker, which you can return to recycling");
        information.setName("Adidas CoolBrand Number 1");
        information.setOwner("");
        information.setPrice("900€");
        information.setOwnerAdress("0x6531A1058CC6e536b54508DCa0f75Dc61c901864");
        productService.buyProduct(information);

    }
}
