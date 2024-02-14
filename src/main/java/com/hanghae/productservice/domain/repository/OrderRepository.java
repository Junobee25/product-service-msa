package com.hanghae.productservice.domain.repository;

import com.hanghae.productservice.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
