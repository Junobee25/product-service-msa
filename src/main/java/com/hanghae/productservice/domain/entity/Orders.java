package com.hanghae.productservice.domain.entity;

import com.hanghae.productservice.domain.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //TODO: (진행중, 완료) Enum 으로 관리하기
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    protected Orders() {

    }

    private Orders(Long userId, Product product, OrderStatus orderStatus) {
        this.userId = userId;
        this.product = product;
        this.orderStatus = orderStatus;
    }

    public static Orders of(Long userId, Product product, OrderStatus orderStatus) {
        return new Orders(userId, product, orderStatus);
    }
}
