package com.abhi.restaurant.service;


import java.util.List;

import com.abhi.restaurant.model.Order;

public interface OrderService {

    Order createOrder(Long customerId);

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    Order updateOrderStatus(Long id, String status);

    void deleteOrder(Long id);
}