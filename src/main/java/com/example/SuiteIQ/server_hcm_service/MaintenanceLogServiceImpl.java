package com.example.SuiteIQ.server_hcm_service;

import com.example.SuiteIQ.server_hcm_domain.MaintenanceLog;
import com.example.SuiteIQ.server_hcm_repository.MaintenanceLogRepository;
import com.example.SuiteIQ.server_hcm_service.MaintenanceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceLogServiceImpl implements MaintenanceLogService {

    @Autowired
    private MaintenanceLogRepository logRepository;

    @Override
    public MaintenanceLog createLog(MaintenanceLog log) {
        return logRepository.save(log);
    }

    @Override
    public List<MaintenanceLog> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public MaintenanceLog getLogById(Long id) {
        return logRepository.findById(id).orElse(null);
    }

    @Override
    public MaintenanceLog updateLog(Long id, MaintenanceLog updatedLog) {
        return logRepository.findById(id).map(existingLog -> {
            // Set JPA relationships properly
            existingLog.setRoom(updatedLog.getRoom());

            // Set regular fields
            existingLog.setIssueDescription(updatedLog.getIssueDescription());
            existingLog.setReportedBy(updatedLog.getReportedBy());
            existingLog.setAssignedTo(updatedLog.getAssignedTo());
            existingLog.setStatus(updatedLog.getStatus());
            existingLog.setResolvedAt(updatedLog.getResolvedAt());

            return logRepository.save(existingLog);
        }).orElse(null);
    }

    @Override
    public void deleteLog(Long id) {
        logRepository.deleteById(id);
    }
}

