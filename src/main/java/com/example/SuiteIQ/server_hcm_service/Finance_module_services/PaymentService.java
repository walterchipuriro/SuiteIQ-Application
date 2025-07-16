package com.example.SuiteIQ.server_hcm_service.Finance_module_services;

import com.example.SuiteIQ.server_hcm_domain.Payment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PaymentService {

        List<Payment> getAllPayments();
        Optional<Payment> getPaymentById(Long id);
        Payment createPayment(Payment payment);  // includes bookingId, methodId, amount
        Optional<Payment> updatePayment(Long id, Payment payment);
        void deletePayment(Long id);

        // Optional:
        List<Payment> getPaymentsByWorker(Long workerId);
        List<Payment> getPaymentsByPaymentDate(LocalDate date);
        double getTotalPaymentsForDate(LocalDate date);
        boolean isBookingPaid(Long bookingId);
    }
