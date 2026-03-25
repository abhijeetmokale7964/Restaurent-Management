package com.abhi.restaurant.service;


import java.util.List;

import com.abhi.restaurant.model.OrderItem;

public interface OrderItemService {

    OrderItem addItemToOrder(Long orderId, Long menuItemId, int quantity);

    List<OrderItem> getItemsByOrder(Long orderId);

    void deleteOrderItem(Long id);
}