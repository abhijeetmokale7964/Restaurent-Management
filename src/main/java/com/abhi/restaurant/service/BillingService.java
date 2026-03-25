package com.abhi.restaurant.service;

import com.abhi.restaurant.model.Bill;

import java.util.List;

public interface BillingService {

    Bill generateBill(Long orderId, double discount);

    Bill getBillByOrderId(Long orderId);

    List<Bill> getAllBills();

    void deleteBill(Long id);
}