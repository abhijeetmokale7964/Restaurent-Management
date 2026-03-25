package com.abhi.restaurant.controller;

import com.abhi.restaurant.model.Bill;
import com.abhi.restaurant.service.BillingService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor
public class BillingController {

    private final BillingService service;

    @PostMapping("/{orderId}")
    public Bill generateBill(@PathVariable Long orderId,
                             @RequestParam double discount) {
        return service.generateBill(orderId, discount);
    }

    @GetMapping("/{orderId}")
    public Bill getBill(@PathVariable Long orderId) {
        return service.getBillByOrderId(orderId);
    }

    @GetMapping
    public List<Bill> getAllBills() {
        return service.getAllBills();
    }

    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable Long id) {
        service.deleteBill(id);
        return "Bill deleted";
    }
}