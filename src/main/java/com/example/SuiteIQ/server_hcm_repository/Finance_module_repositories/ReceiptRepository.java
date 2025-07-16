package com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories;

import com.example.SuiteIQ.server_hcm_domain.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Optional<Receipt> findByPaymentBookingId(Long bookingId);
}


