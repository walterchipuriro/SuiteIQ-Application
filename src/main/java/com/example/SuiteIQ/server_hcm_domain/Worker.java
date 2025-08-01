package com.example.SuiteIQ.server_hcm_domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private String password;

    private boolean active = true;

    @Column(name = "reset_token")
    private String resetToken;

    @Column(name = "token_expiry")
    private LocalDateTime tokenExpiry;

}
