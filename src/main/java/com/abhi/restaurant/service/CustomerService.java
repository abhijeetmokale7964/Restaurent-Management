package com.abhi.restaurant.service;

import java.util.List;

import com.abhi.restaurant.model.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);
}