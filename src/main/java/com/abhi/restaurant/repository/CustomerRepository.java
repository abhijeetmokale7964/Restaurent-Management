package com.abhi.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.restaurant.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}