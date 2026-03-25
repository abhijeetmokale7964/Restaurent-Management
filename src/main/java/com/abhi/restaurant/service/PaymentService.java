package com.abhi.restaurant.service;

import com.abhi.restaurant.model.Payment;

public interface PaymentService {

    Payment payBill(Long billId, String method);
    
}