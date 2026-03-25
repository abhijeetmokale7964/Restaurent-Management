package com.abhi.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.restaurant.model.RestaurantTable;

public interface TableRepository extends JpaRepository<RestaurantTable, Long> {

}