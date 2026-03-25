package com.abhi.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.restaurant.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}