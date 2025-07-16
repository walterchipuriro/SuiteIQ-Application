package com.example.SuiteIQ.server_hcm_domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Worker {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String fullName;

    @Setter
    private String role; // e.g., Receptionist, Manager, Cashier

    @Setter
    private String email;

    @Setter
    private String phone;

    @Setter
    private boolean active = true;

    // Constructors
    public Worker() {}

    public Worker(String fullName, String role, String email, String phone) {
        this.fullName = fullName;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    public Object getName() {
        return null;
    }

    public void setName(Object name) {
    }
}

