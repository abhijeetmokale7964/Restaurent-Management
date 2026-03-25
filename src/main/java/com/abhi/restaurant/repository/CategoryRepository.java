package com.abhi.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.restaurant.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}