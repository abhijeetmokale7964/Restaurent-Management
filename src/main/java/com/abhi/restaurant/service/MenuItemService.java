package com.abhi.restaurant.service;

import java.util.List;

import com.abhi.restaurant.model.MenuItem;

public interface MenuItemService {

    MenuItem createMenuItem(MenuItem menuItem);

    List<MenuItem> getAllMenuItems();

    MenuItem getMenuItemById(Long id);

    MenuItem updateMenuItem(Long id, MenuItem menuItem);

    void deleteMenuItem(Long id);
}