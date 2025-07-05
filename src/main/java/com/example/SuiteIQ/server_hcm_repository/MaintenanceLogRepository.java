package com.example.SuiteIQ.server_hcm_repository;

import com.example.SuiteIQ.server_hcm_domain.MaintenanceLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceLogRepository extends JpaRepository<MaintenanceLog, Long> {
}

