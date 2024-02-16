package com.hanghae.productservice.controller.dto;

import com.hanghae.productservice.domain.constant.OrderStatus;
import com.hanghae.productservice.domain.entity.Orders;

public record OrdersDto(

    Long id,

    Long userId,

    Long productId,

    OrderStatus orderStatus
) {

    public static OrdersDto from(Orders entity) {
        return new OrdersDto(
                entity.getId(),
                entity.getUserId(),
                entity.getProduct().getProductId(),
                entity.getOrderStatus()
        );
    }
}
