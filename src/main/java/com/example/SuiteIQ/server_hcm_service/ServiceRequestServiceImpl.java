package com.example.SuiteIQ.server_hcm_service;

import com.example.SuiteIQ.server_hcm_domain.ServiceRequest;
import com.example.SuiteIQ.server_hcm_repository.ServiceRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

    private final ServiceRequestRepository repository;

    public ServiceRequestServiceImpl(ServiceRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceRequest createRequest(ServiceRequest request) {
        request.setTimestamp(java.time.LocalDateTime.now());
        return repository.save(request);
    }

    @Override
    public List<ServiceRequest> getAllRequests() {
        return repository.findAll();
    }

    @Override
    public Optional<ServiceRequest> getRequestById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ServiceRequest updateRequest(Long id, ServiceRequest updatedRequest) {
        return repository.findById(id).map(existing -> {
            existing.setUser(updatedRequest.getUser());
            existing.setRoom(updatedRequest.getRoom());
            existing.setRequestType(updatedRequest.getRequestType());
            existing.setDescription(updatedRequest.getDescription());
            existing.setStatus(updatedRequest.getStatus());
            existing.setAssignedTo(updatedRequest.getAssignedTo());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Request not found"));
    }


    @Override
    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}
