package com.example.SuiteIQ.server_hcm_controller.Finance_module_controllers;


import com.example.SuiteIQ.server_hcm_domain.ServiceRequest;
import com.example.SuiteIQ.server_hcm_service.ServiceRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-requests")
public class ServiceRequestController {

    private final ServiceRequestService service;

    public ServiceRequestController(ServiceRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ServiceRequest> createRequest(@RequestBody ServiceRequest request) {
        return ResponseEntity.ok(service.createRequest(request));
    }

    @GetMapping
    public ResponseEntity<List<ServiceRequest>> getAllRequests() {
        return ResponseEntity.ok(service.getAllRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequest> getRequestById(@PathVariable Long id) {
        return service.getRequestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRequest> updateRequest(@PathVariable Long id, @RequestBody ServiceRequest request) {
        return ResponseEntity.ok(service.updateRequest(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        service.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}