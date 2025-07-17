package com.example.SuiteIQ.server_hcm_domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String receiptNumber;

    private LocalDateTime issuedAt;

    private String customer;

    private String description;

    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    // Constructors
    public Receipt() {
    }

    public Receipt(String receiptNumber, LocalDateTime issuedAt, String customer, String description, BigDecimal amount, Payment payment) {
        this.receiptNumber = receiptNumber;
        this.issuedAt = issuedAt;
        this.customer = customer;
        this.description = description;
        this.amount = amount;
        this.payment = payment;
    }

    // Getters and Setters manually added (if not relying on Lombok)

    public void setBooking(Booking booking) {
    }

    public void setIssueDate(LocalDate now) {
    }

    public LocalDate getIssueDate() {
        return null;
    }
}
