package com.hanghae.productservice.controller.dto;

import com.hanghae.productservice.domain.entity.Order;

public record OrderDto(

    Long id,

    Long userId,

    Long productId
) {

    public static OrderDto from(Order entity) {
        return new OrderDto(
                entity.getId(),
                entity.getUserId(),
                entity.getProduct().getProductId()
        );
    }
}
