package com.abhi.restaurant.serviceImpl;

import com.abhi.restaurant.model.*;
import com.abhi.restaurant.repository.BillRepository;
import com.abhi.restaurant.repository.PaymentRepository;
import com.abhi.restaurant.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BillRepository billRepository;

    @Override
    public Payment payBill(Long billId, String method) {

        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        bill.setPaymentStatus(PaymentStatus.PAID);

        Payment payment = new Payment();
        payment.setBill(bill);
        payment.setAmount(bill.getFinalAmount());
        payment.setPaymentMethod(PaymentMethod.valueOf(method.toUpperCase()));
        payment.setPaymentDate(LocalDateTime.now());

        log.info("Processing payment for bill id: {}", billId);

        return paymentRepository.save(payment);
    }
}