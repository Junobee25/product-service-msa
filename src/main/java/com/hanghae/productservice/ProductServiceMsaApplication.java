package com.hanghae.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProductServiceMsaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceMsaApplication.class, args);
    }

}
