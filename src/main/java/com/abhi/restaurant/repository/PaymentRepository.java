package com.abhi.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.restaurant.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}