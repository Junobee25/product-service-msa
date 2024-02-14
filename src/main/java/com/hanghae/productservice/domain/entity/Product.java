package com.hanghae.productservice.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean reservation;

    protected Product() {

    }

    private Product(String name, Integer price, String description, Integer stock, Boolean reservation) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.reservation = reservation;
    }

    public static Product of(String name, Integer price, String description, Integer stock, Boolean reservation) {
        return new Product(name, price, description, stock, reservation);
    }
}


