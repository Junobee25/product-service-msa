package com.hanghae.productservice.service;

import com.hanghae.productservice.controller.dto.OrdersDto;
import com.hanghae.productservice.domain.constant.OrderStatus;
import com.hanghae.productservice.domain.entity.Orders;
import com.hanghae.productservice.domain.entity.Product;
import com.hanghae.productservice.domain.repository.OrdersRepository;
import com.hanghae.productservice.domain.repository.ProductRepository;
import com.hanghae.productservice.external.client.UserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final ProductRepository productRepository;
    private final OrdersRepository orderRepository;
    private final UserServiceClient userServiceClient;

    public OrdersDto order(Long productId, HttpHeaders headers) {
        String userEmail = userServiceClient.getUserEmail(headers);
        Product product = productRepository.findById(productId)
                .orElseThrow(RuntimeException::new);


        Optional<Long> userIdOpt = userServiceClient.getUserId(userEmail);
        Long userId = userIdOpt.orElseThrow(() -> new RuntimeException("User ID not found"));

        return OrdersDto.from(orderRepository.save(Orders.of(userId, product, OrderStatus.COMPLETE)));
    }
}
