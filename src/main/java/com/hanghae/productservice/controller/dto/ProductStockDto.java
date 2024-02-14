package com.hanghae.productservice.controller.dto;

import com.hanghae.productservice.domain.entity.Product;

public record ProductStockDto(

        String name,
        Integer stock
) {

    public static ProductStockDto from(Product entity) {
        return new ProductStockDto(
                entity.getName(),
                entity.getStock()
        );
    }
}
