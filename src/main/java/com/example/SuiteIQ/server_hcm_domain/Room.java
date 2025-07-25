package com.example.SuiteIQ.server_hcm_domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Reviews> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<MaintenanceLog> maintenanceLogs = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<ServiceRequest> serviceRequests = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();

}

