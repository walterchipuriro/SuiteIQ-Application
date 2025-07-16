package com.example.SuiteIQ.server_hcm_domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Entity
public class PaymentMethod {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String method; // e.g., CASH, ECO CASH, USD, SWIPE

    // Constructors
    public PaymentMethod() {
    }

    public PaymentMethod(String method) {
        this.method = method;
    }

}
