package com.example.SuiteIQ.server_hcm_domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
public class Receipt {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String receiptNumber;

    @Setter
    private LocalDateTime issuedAt;

    @Setter
    private String customer;

    @Setter
    private String description;

    @Setter
    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    // Constructors
    public Receipt() {}

    public Receipt(String receiptNumber, LocalDateTime issuedAt, String customer, String description, Payment payment) {
        this.receiptNumber = receiptNumber;
        this.issuedAt = issuedAt;
        this.customer = customer;
        this.description = description;
        this.payment = payment;
    }

    public void setIssueDate(LocalDate now) {

    }

    public void setBooking(Object booking) {
    }

    public void setAmount(BigDecimal amount) {
    }

    public BigDecimal getAmount() {
        return null;
    }

    public LocalDate getIssueDate() {
        return null;
    }


}
