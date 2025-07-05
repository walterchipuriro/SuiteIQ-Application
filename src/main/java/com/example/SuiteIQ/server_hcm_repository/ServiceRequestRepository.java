package com.example.SuiteIQ.server_hcm_repository;


import com.example.SuiteIQ.server_hcm_domain.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
}
