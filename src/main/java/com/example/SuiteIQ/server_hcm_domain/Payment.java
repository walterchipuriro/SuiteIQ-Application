package com.example.SuiteIQ.server_hcm_domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private LocalDateTime paymentDate;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    // Default constructor
    public Payment() {}

    // Proper constructor using entity references
    public Payment(BigDecimal amount, LocalDateTime paymentDate, PaymentMethod paymentMethod, Booking booking, Worker worker) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.booking = booking;
        this.worker = worker;
    }
}
