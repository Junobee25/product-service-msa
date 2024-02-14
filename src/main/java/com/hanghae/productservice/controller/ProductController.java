package com.hanghae.productservice.controller;

import com.hanghae.productservice.controller.dto.ProductDetailDto;
import com.hanghae.productservice.controller.dto.ProductDto;
import com.hanghae.productservice.controller.dto.ProductStockDto;
import com.hanghae.productservice.controller.dto.response.Response;
import com.hanghae.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public Response<List<ProductDto>> viewProduct() {
        return Response.success(productService.viewProductList());
    }

    @GetMapping("/products/detail/{productId}")
    public Response<ProductDetailDto> viewProductDetail(@PathVariable(value = "productId") Long productId) {
        return Response.success(productService.viewProductDetail(productId));
    }

    @GetMapping("/products/stock/{productId}")
    public Response<ProductStockDto> viewProductStock(@PathVariable(value = "productId") Long productId) {
        return Response.success(productService.viewProductStock(productId));
    }
}
