package com.abhi.restaurant.serviceImpl;

import com.abhi.restaurant.model.*;
import com.abhi.restaurant.repository.*;
import com.abhi.restaurant.service.BillingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BillingServiceImpl implements BillingService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final BillRepository billRepository;

    @Override
    public Bill generateBill(Long orderId, double discount) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        List<OrderItem> items = orderItemRepository.findByOrderId(orderId);

        double total = items.stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();

        double tax = total * 0.05; // 5% tax
        double finalAmount = total + tax - discount;

        Bill bill = new Bill();
        bill.setOrder(order);
        bill.setTotalAmount(total);
        bill.setTax(tax);
        bill.setDiscount(discount);
        bill.setFinalAmount(finalAmount);
        bill.setPaymentStatus(PaymentStatus.UNPAID);

        log.info("Generating bill for order id: {}", orderId);

        return billRepository.save(bill);
    }

    @Override
    public Bill getBillByOrderId(Long orderId) {
        return billRepository.findByOrderId(orderId);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public void deleteBill(Long id) {

        log.warn("Deleting bill id: {}", id);

        billRepository.deleteById(id);
    }
}