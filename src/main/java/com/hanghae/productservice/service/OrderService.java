package com.hanghae.productservice.service;

import com.hanghae.productservice.domain.entity.Product;
import com.hanghae.productservice.domain.repository.OrderRepository;
import com.hanghae.productservice.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public void order(Long productId, Long userId, Integer quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(RuntimeException::new);

    }

}
