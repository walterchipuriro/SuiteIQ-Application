package com.example.SuiteIQ.server_hcm_domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
public class Payment {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private BigDecimal amount;

    @Setter
    private LocalDateTime paymentDate;

    @Setter
    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Setter
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Setter
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    // Default constructor
    public Payment() {}

    // Parameterized constructor
    public Payment(BigDecimal amount, LocalDateTime paymentDate, PaymentMethod paymentMethod, Booking booking, Worker worker) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.booking = booking;
        this.worker = worker;
    }

}
