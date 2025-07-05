package com.example.SuiteIQ.server_hcm_service;

import com.example.SuiteIQ.server_hcm_domain.MaintenanceLog;

import java.util.List;

public interface MaintenanceLogService {
    MaintenanceLog createLog(MaintenanceLog log);
    List<MaintenanceLog> getAllLogs();
    MaintenanceLog getLogById(Long id);
    MaintenanceLog updateLog(Long id, MaintenanceLog updatedLog);
    void deleteLog(Long id);
}

