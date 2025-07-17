package com.example.SuiteIQ.server_hcm_service.Finance_module_services;

import com.example.SuiteIQ.server_hcm_domain.Booking;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookingService {
        List<Booking> getAllBookings();
        List<Booking> getBookingsByRoom(Long roomId);
        List<Booking> getBookingsByClientName(String clientName);
        List<Booking> getBookingsByTimeRange(LocalDateTime from, LocalDateTime to);
        Optional<Booking> getBookingById(Long id);
        Booking createBooking(Booking booking);  // e.g. select room, duration
        Optional<Booking> updateBooking(Long id, Booking booking);
        void deleteBooking(Long id);

        // Optional: helper methods
        List<Booking> getBookingsByClient(String clientName);
        List<Booking> findByCheckInTimeBetween(LocalDateTime from, LocalDateTime to);
}
