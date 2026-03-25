package com.abhi.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.restaurant.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}