package com.example.SuiteIQ.server_hcm_controller;

import com.example.SuiteIQ.server_hcm_domain.MaintenanceLog;
import com.example.SuiteIQ.server_hcm_service.MaintenanceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance-logs")
public class MaintenanceLogController {

    @Autowired
    private MaintenanceLogService logService;

    @PostMapping
    public MaintenanceLog createLog(@RequestBody MaintenanceLog log) {
        return logService.createLog(log);
    }

    @GetMapping
    public List<MaintenanceLog> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("/{id}")
    public MaintenanceLog getLogById(@PathVariable Long id) {
        return logService.getLogById(id);
    }

    @PutMapping("/{id}")
    public MaintenanceLog updateLog(@PathVariable Long id, @RequestBody MaintenanceLog updatedLog) {
        return logService.updateLog(id, updatedLog);
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Long id) {
        logService.deleteLog(id);
    }
}

