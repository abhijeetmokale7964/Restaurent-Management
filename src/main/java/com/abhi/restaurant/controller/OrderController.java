package com.abhi.restaurant.controller;

import com.abhi.restaurant.model.Order;
import com.abhi.restaurant.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService service;

    // create order
    @PostMapping("/create/{customerId}")
    public ResponseEntity<Order> createOrder(@PathVariable Long customerId) {

        log.info("API call to create order");

        return ResponseEntity.ok(service.createOrder(customerId));
    }

    // get order by id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {

        return ResponseEntity.of(
                java.util.Optional.ofNullable(service.getOrderById(id))
        );
    }

    // get all orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {

        return ResponseEntity.ok(service.getAllOrders());
    }

    // update status
    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable Long id,
                                              @RequestParam String status) {

        return ResponseEntity.ok(service.updateOrderStatus(id, status));
    }

    // delete order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {

        service.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }
}