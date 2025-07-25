package com.example.SuiteIQ.server_hcm_domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String roomNumber;

    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    private boolean paid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus bookingStatus = BookingStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Enum for booking status
    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        CANCELLED,
        COMPLETED
    }

    // Optional helper method
    public void setCancelled(boolean isCancelled) {
        if (isCancelled) {
            this.bookingStatus = BookingStatus.CANCELLED;
        }
    }
}
