package com.example.SuiteIQ.server_hcm_service.Finance_module_implementations;

import com.example.SuiteIQ.server_hcm_domain.Booking;
import com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories.BookingRepository;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.BookingService;
import org.springframework.stereotype.Service;


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
        public Optional<Booking> getBookingById(Long id) {
            return bookingRepository.findById(id);
        }

        @Override
        public Booking createBooking(Booking booking) {
            return bookingRepository.save(booking);
        }

        @Override
        public Optional<Booking> updateBooking(Long id, Booking updatedBooking) {
            return bookingRepository.findById(id).map(existing -> {
                existing.setCustomerName(updatedBooking.getCustomerName());
                existing.setCheckInTime(updatedBooking.getCheckInTime());
                existing.setCheckOutTime(updatedBooking.getCheckOutTime());
                existing.setRoomNumber(updatedBooking.getRoomNumber());
//                existing.setPaid(updatedBooking.isPaid());
                return bookingRepository.save(existing);
            });
        }

        @Override
        public void deleteBooking(Long id) {
            bookingRepository.deleteById(id);
        }

        @Override
        public List<Booking> getBookingsByClient(String clientName) {
            return bookingRepository.findByCustomerName(clientName);
        }

        @Override
        public List<Booking> findByCheckInTimeBetween(LocalDateTime from, LocalDateTime to) {
            return null;
        }
    }

