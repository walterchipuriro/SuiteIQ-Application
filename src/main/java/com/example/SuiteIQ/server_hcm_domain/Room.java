package com.example.SuiteIQ.server_hcm_domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    private String roomTypeId; // e.g. "SINGLE", "DOUBLE", "DELUXE"

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    private Double price;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "room_features", joinColumns = @JoinColumn(name = "room_id"))
    @Column(name = "feature")
    private Set<String> features; // e.g. "AC", "WiFi", "TV", "Balcony"
}

