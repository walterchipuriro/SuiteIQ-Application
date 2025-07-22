package com.example.SuiteIQ.server_hcm_service.Finance_module_implementations;

import com.example.SuiteIQ.server_hcm_domain.Booking;
import com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories.BookingRepository;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByRoom(Long roomId) {
        return List.of(); // Implement if needed
    }

    @Override
    public List<Booking> getBookingsByClientName(String clientName) {
        return List.of(); // Implement if needed
    }

    @Override
    public List<Booking> getBookingsByTimeRange(LocalDateTime from, LocalDateTime to) {
        return List.of(); // Implement if needed
    }

    @Override
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Booking createBooking(Booking booking) {
        booking.setBookingStatus(Booking.BookingStatus.PENDING); // Set default status
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id).map(existing -> {
            existing.setCustomerName(updatedBooking.getCustomerName());
            existing.setCheckInTime(updatedBooking.getCheckInTime());
            existing.setCheckOutTime(updatedBooking.getCheckOutTime());
            existing.setRoomNumber(updatedBooking.getRoomNumber());
            // existing.setPaid(updatedBooking.isPaid());
            return bookingRepository.save(existing);
        });
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Optional<Booking> confirmBooking(Long id) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setBookingStatus(Booking.BookingStatus.CONFIRMED);
            return bookingRepository.save(booking);
        });
    }

    @Override
    public Optional<Booking> markAsPaid(Long id) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setPaid(true);
            return bookingRepository.save(booking);
        });
    }

    @Override
    public Optional<Booking> cancelBooking(Long id) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setBookingStatus(Booking.BookingStatus.CANCELLED);
            return bookingRepository.save(booking);
        });
    }

    @Override
    public List<Booking> getBookingsByClient(String clientName) {
        return bookingRepository.findByCustomerName(clientName);
    }

    @Override
    public List<Booking> findByCheckInTimeBetween(LocalDate from, LocalDateTime to) {
        return bookingRepository.findByCheckInTimeBetween(from, LocalDate.from(to));
    }
}
