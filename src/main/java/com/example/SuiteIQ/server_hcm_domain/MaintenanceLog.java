package com.example.SuiteIQ.server_hcm_domain;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "maintenance_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    private Long roomId;

    private String issueDescription;

    private String reportedBy;

    private String assignedTo;

    private String status;

    private LocalDateTime resolvedAt;
}
