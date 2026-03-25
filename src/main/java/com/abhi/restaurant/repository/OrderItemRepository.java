package com.abhi.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.restaurant.model.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    // Get all items for a specific order
    List<OrderItem> findByOrderId(Long orderId);
}