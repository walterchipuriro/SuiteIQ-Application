package com.example.SuiteIQ.server_hcm_service.Finance_module_implementations;

import com.example.SuiteIQ.server_hcm_domain.Payment;
import com.example.SuiteIQ.server_hcm_domain.Worker;
import com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories.WorkerRepository;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.WorkerService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository repository;

    public WorkerServiceImpl(WorkerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Worker> getAllWorkers() {
        return repository.findAll();
    }

    @Override
    public Optional<Worker> getWorkerById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Worker createWorker(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Optional<Worker> updateWorker(Long id, Worker updatedWorker) {
        return repository.findById(id).map(existing -> {
            existing.setFullName(updatedWorker.getFullName());
            existing.setRole(updatedWorker.getRole());
            // etc...
            return repository.save(existing);
        });
    }

    @Override
    public void deleteWorker(Long id) {
        repository.deleteById(id);
    }

    @Override
    public double getTotalCollectedByWorker(Long workerId) {
        return 0;
    }

    @Override
    public List<Payment> getPaymentsProcessedByWorker(Long workerId) {
        return List.of();
    }
}

