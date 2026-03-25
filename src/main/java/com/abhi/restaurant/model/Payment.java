package com.abhi.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Bill bill;

    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private LocalDateTime paymentDate;
}