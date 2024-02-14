package com.hanghae.productservice.controller.dto;

import com.hanghae.productservice.domain.entity.Product;

public record ProductDto(

    Long id,

    String name,

    Integer price,

    String description,

    Boolean reservation
) {

    public static ProductDto from(Product entity) {
       return new ProductDto(
               entity.getProductId(),
               entity.getName(),
               entity.getPrice(),
               entity.getDescription(),
               entity.getReservation()
       );
    }
}
