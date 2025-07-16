package com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories;


import com.example.SuiteIQ.server_hcm_domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCheckInTimeBetween(LocalDate startDate, LocalDate endDate);

    List<Booking> findByCustomerName(String clientName);
}

