package com.hanghae.productservice.controller;

import com.hanghae.productservice.controller.dto.OrdersDto;
import com.hanghae.productservice.controller.dto.request.OrdersRequestDto;
import com.hanghae.productservice.controller.dto.response.Response;
import com.hanghae.productservice.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-service")
public class OrdersController {

    private final OrdersService orderService;

    @PostMapping("/order")
    public Response<OrdersDto> order(@RequestBody OrdersRequestDto orderRequestDto, @RequestHeader HttpHeaders headers) {
        return Response.success(orderService.order(orderRequestDto.productId(), headers));
    }
}
