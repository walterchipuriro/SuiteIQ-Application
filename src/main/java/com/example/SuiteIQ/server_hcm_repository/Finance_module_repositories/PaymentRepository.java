package com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories;


import com.example.SuiteIQ.server_hcm_domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByWorkerId(Long workerId);
    List<Payment> findByPaymentDate(LocalDate date);
    List<Payment> findByBooking_Id(Long bookingId);


}

