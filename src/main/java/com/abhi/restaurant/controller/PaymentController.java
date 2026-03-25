package com.abhi.restaurant.controller;

import com.abhi.restaurant.model.Payment;
import com.abhi.restaurant.service.PaymentService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping("/{billId}")
    public Payment pay(@PathVariable Long billId,
                       @RequestParam String method) {
        return service.payBill(billId, method);
    }
}