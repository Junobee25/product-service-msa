package com.hanghae.productservice.controller;

import com.hanghae.productservice.controller.dto.ProductDetailDto;
import com.hanghae.productservice.controller.dto.ProductDto;
import com.hanghae.productservice.controller.dto.ProductStockDto;
import com.hanghae.productservice.controller.dto.request.ProductEnrollmentRequest;
import com.hanghae.productservice.controller.dto.response.Response;
import com.hanghae.productservice.domain.constant.ProductType;
import com.hanghae.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-service")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public Response<List<ProductDto>> viewProduct() {
        return Response.success(productService.viewProductList());
    }

    @PostMapping("/products")
    public Response<Void> enrollProduct(@RequestBody ProductEnrollmentRequest request) {
        productService.enrollProduct(
                request.name(),
                request.price(),
                request.description(),
                request.stock(),
                request.productType());

        return Response.success();
    }

    @GetMapping("/products/{productType}")
    public Response<List<ProductDto>> viewProductType(@PathVariable(value="productType") ProductType productType) {
        return Response.success(productService.viewProductType(productType));
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
