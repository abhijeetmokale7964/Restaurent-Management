package com.abhi.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.restaurant.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

    Bill findByOrderId(Long orderId);
}