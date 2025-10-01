package com.example.SuiteIQ.server_hcm_domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String username;      // New

    private String dateOfBirth;   // New — store as String or better as LocalDate if you want

    private String nationalId;    // New

    private String homeAddress;   // New

    private String role; // e.g., Receptionist, Manager, Cashier

    private String email;

    private String phone;

    private String password;

    private boolean active = true;
}
