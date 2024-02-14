package com.hanghae.productservice.controller;

import com.hanghae.productservice.controller.dto.response.Response;
import com.hanghae.productservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-service")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/entry-payment")
    public Response<Void> entryPayment(@RequestHeader HttpHeaders headers) {
        paymentService.entryPayment(headers);
        return Response.success();
    }
}
