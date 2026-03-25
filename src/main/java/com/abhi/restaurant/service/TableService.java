package com.abhi.restaurant.service;

import java.util.List;

import com.abhi.restaurant.model.RestaurantTable;

public interface TableService {

    RestaurantTable addTable(RestaurantTable table);

    List<RestaurantTable> getAllTables();

    RestaurantTable updateTable(Long id, RestaurantTable table);

    void deleteTable(Long id);

}