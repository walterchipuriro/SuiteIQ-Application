package com.example.SuiteIQ.server_hcm_service.Finance_module_services;

import com.example.SuiteIQ.server_hcm_domain.Payment;
import com.example.SuiteIQ.server_hcm_domain.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerService {
        List<Worker> getAllWorkers();
        Optional<Worker> getWorkerById(Long id);
        Worker createWorker(Worker worker);
        Optional<Worker> updateWorker(Long id, Worker worker);
        void deleteWorker(Long id);

        // Optional:
        double getTotalCollectedByWorker(Long workerId);
        List<Payment> getPaymentsProcessedByWorker(Long workerId);

        boolean authenticate(String username, String password);

        void registerWorker(Worker worker);

        void initiatePasswordReset(String emailOrUsername);

        void resetPassword(String token, String newPassword);
}

