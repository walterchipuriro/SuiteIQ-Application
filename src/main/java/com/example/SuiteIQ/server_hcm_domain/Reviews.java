package com.example.SuiteIQ.server_hcm_domain;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Long userId;
    private Long roomId;

    private int rating; // e.g., 1 to 5
    private String comment;

    private LocalDateTime timestamp;
}

