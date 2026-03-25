package com.abhi.restaurant.serviceImpl;

import com.abhi.restaurant.model.*;
import com.abhi.restaurant.repository.CustomerRepository;
import com.abhi.restaurant.repository.OrderRepository;
import com.abhi.restaurant.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    // create order
    @Override
    public Order createOrder(Long customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderTime(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        log.info("Creating order for customer id: {}", customerId);

        return orderRepository.save(order);
    }

    // get order by id
    @Override
    public Order getOrderById(Long id) {

        log.info("Fetching order id: {}", id);

        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // get all orders
    @Override
    public List<Order> getAllOrders() {

        log.info("Fetching all orders");

        return orderRepository.findAll();
    }

    // update status
    @Override
    public Order updateOrderStatus(Long id, String status) {

        Order order = getOrderById(id);

        order.setStatus(OrderStatus.valueOf(status.toUpperCase()));

        log.info("Updating order status id: {} to {}", id, status);

        return orderRepository.save(order);
    }

    // delete order
    @Override
    public void deleteOrder(Long id) {

        Order order = getOrderById(id);

        log.warn("Deleting order id: {}", id);

        orderRepository.delete(order);
    }
}