package com.example.SuiteIQ.server_hcm_controller.Finance_module_controllers;

import com.example.SuiteIQ.server_hcm_domain.Booking;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

        private final BookingService bookingService;

        public BookingController(BookingService bookingService) {
            this.bookingService = bookingService;
        }

        @GetMapping
        public List<Booking> getAllBookings() {
            return bookingService.getAllBookings();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
            return ResponseEntity.of(bookingService.getBookingById(id));
        }

        @PostMapping
        public Booking createBooking(@RequestBody Booking booking) {
            return bookingService.createBooking(booking);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
            return ResponseEntity.of(bookingService.updateBooking(id, booking));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
            bookingService.deleteBooking(id);
            return ResponseEntity.noContent().build();
        }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/confirm")
    public ResponseEntity<Booking> confirmBooking(@PathVariable Long id) {
        return bookingService.confirmBooking(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @RequestMapping(value = "/{id}/pay", method = {RequestMethod.PATCH, RequestMethod.POST})
    public ResponseEntity<Booking> markAsPaid(@PathVariable Long id) {
        return bookingService.markAsPaid(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

