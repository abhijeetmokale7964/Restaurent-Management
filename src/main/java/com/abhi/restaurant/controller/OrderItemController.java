package com.abhi.restaurant.controller;

import com.abhi.restaurant.model.OrderItem;
import com.abhi.restaurant.service.OrderItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@RequiredArgsConstructor
@Slf4j
public class OrderItemController {

    private final OrderItemService service;

    // add item
    @PostMapping
    public ResponseEntity<OrderItem> addItem(@RequestParam Long orderId,
                                             @RequestParam Long menuItemId,
                                             @RequestParam int quantity) {

        return ResponseEntity.ok(
                service.addItemToOrder(orderId, menuItemId, quantity)
        );
    }

    // get items
    @GetMapping("/{orderId}")
    public ResponseEntity<List<OrderItem>> getItems(@PathVariable Long orderId) {

        return ResponseEntity.ok(service.getItemsByOrder(orderId));
    }

    // delete item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {

        service.deleteOrderItem(id);

        return ResponseEntity.noContent().build();
    }
}