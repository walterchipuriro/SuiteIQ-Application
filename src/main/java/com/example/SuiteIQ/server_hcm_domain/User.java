package com.example.SuiteIQ.server_hcm_domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users") // optional but avoids clash with SQL 'user' keyword
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean enabled = true;
    private boolean locked = false;

    @Column(nullable = false)
    private String role; // e.g., ROLE_MANAGER, ROLE_ADMIN, ROLE_WORKER

    @Column(name = "failed_attempts")
    private int failedAttempts = 0;

    @Column(name = "lock_time")
    private LocalDateTime lockTime;

}

