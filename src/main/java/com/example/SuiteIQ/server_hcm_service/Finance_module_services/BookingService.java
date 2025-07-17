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

        Booking createBooking(Booking booking);

        Optional<Booking> updateBooking(Long id, Booking booking);

        void deleteBooking(Long id);

        Optional<Booking> confirmBooking(Long id);

        Optional<Booking> markAsPaid(Long id);

        Optional<Booking> cancelBooking(Long id);

        // Optional helper methods (if needed)
        List<Booking> getBookingsByClient(String clientName);

        List<Booking> findByCheckInTimeBetween(LocalDateTime from, LocalDateTime to);
}
