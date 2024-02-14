package com.hanghae.productservice.service;

import com.hanghae.productservice.domain.entity.Orders;
import com.hanghae.productservice.domain.entity.Product;
import com.hanghae.productservice.domain.repository.OrdersRepository;
import com.hanghae.productservice.external.client.UserServiceClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final OrdersRepository ordersRepository;
    private final UserServiceClient userServiceClient;

    @Transactional
    public void entryPayment(HttpHeaders headers) {
        String userEmail = userServiceClient.getUserEmail(headers);
        Optional<Long> userIdOpt = userServiceClient.getUserId(userEmail);
        Long userId = userIdOpt.orElseThrow(() -> new RuntimeException("User ID not found"));

        List<Orders> orders = ordersRepository.findByUserId(userId);

        orders.forEach(order -> {
            Product product = order.getProduct();
            product.removeStock();
        });
    }
}
