package com.abhi.restaurant.serviceImpl;

import com.abhi.restaurant.model.*;
import com.abhi.restaurant.repository.MenuItemRepository;
import com.abhi.restaurant.repository.OrderItemRepository;
import com.abhi.restaurant.repository.OrderRepository;
import com.abhi.restaurant.service.OrderItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderRepository orderRepository;
    private final MenuItemRepository menuItemRepository;
    private final OrderItemRepository orderItemRepository;

    // add item to order
    @Override
    public OrderItem addItemToOrder(Long orderId, Long menuItemId, int quantity) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        OrderItem item = new OrderItem();
        item.setOrder(order);
        item.setMenuItem(menuItem);
        item.setQuantity(quantity);
        item.setPrice(menuItem.getPrice());

        log.info("Adding item {} to order {}", menuItemId, orderId);

        return orderItemRepository.save(item);
    }

    // get items by order
    @Override
    public List<OrderItem> getItemsByOrder(Long orderId) {

        log.info("Fetching items for order id: {}", orderId);

        return orderItemRepository.findByOrderId(orderId);
    }

    // delete item
    @Override
    public void deleteOrderItem(Long id) {

        OrderItem item = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order item not found"));

        log.warn("Deleting order item id: {}", id);

        orderItemRepository.delete(item);
    }
}