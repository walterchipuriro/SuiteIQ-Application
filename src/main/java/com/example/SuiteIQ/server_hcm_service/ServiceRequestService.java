package com.example.SuiteIQ.server_hcm_service;

import com.example.SuiteIQ.server_hcm_domain.ServiceRequest;
import java.util.List;
import java.util.Optional;

public interface ServiceRequestService {

    ServiceRequest createRequest(ServiceRequest request);

    List<ServiceRequest> getAllRequests();

    Optional<ServiceRequest> getRequestById(Long id);

    ServiceRequest updateRequest(Long id, ServiceRequest request);

    void deleteRequest(Long id);
}
