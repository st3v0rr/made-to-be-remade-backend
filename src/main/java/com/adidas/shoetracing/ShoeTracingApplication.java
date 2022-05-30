package com.adidas.shoetracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ShoeTracingApplication  {



    public static void main(String[] args) {
        SpringApplication.run(ShoeTracingApplication.class, args);
    }

}
