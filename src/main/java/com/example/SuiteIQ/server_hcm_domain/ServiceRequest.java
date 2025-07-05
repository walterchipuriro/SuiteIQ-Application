package com.example.SuiteIQ.server_hcm_domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "service_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    private Long userId;
    private Long roomId;

    private String requestType;

    private String description;

    private String status;

    private String assignedTo;

    private LocalDateTime timestamp;
}
