package com.abhi.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;

    private double totalAmount;
    private double tax;
    private double discount;
    private double finalAmount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}