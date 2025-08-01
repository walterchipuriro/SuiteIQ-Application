package com.example.SuiteIQ.server_hcm_service.Finance_module_implementations;

import com.example.SuiteIQ.server_hcm_domain.Payment;
import com.example.SuiteIQ.server_hcm_domain.Worker;
import com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories.WorkerRepository;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        // Check for existing email
        if (repository.findByEmail(worker.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Check for existing username
        if (repository.findByUsername(worker.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        // Check for existing national ID
        if (repository.findByNationalId(worker.getNationalId()).isPresent()) {
            throw new IllegalArgumentException("National ID already exists");
        }

        String hashedPassword = passwordEncoder.encode(worker.getPassword());
        worker.setPassword(hashedPassword);

        return repository.save(worker);

    }

    @Override
    public Optional<Worker> updateWorker(Long id, Worker updatedWorker) {
        return repository.findById(id).map(existing -> {
            existing.setFullName(updatedWorker.getFullName());
            existing.setRole(updatedWorker.getRole());
            existing.setEmail(updatedWorker.getEmail());
            existing.setUsername(updatedWorker.getUsername());
            existing.setNationalId(updatedWorker.getNationalId());
            // Add other fields if needed
            return repository.save(existing);
        });
    }

    @Override
    public void deleteWorker(Long id) {
        repository.deleteById(id);
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public double getTotalCollectedByWorker(Long workerId) {
        return 0;
    }

    @Override
    public List<Payment> getPaymentsProcessedByWorker(Long workerId) {
        return List.of();
    }

    @Override
    public boolean authenticate(String username, String password) {
//        System.out.println("Checking credentials for: " + username + " / " + password);
        return repository.findByUsernameAndPassword(username, password).isPresent();
    }

    @Override
    public void registerWorker(Worker worker) {
        // Encrypt the password before saving
        String encodedPassword = passwordEncoder.encode(worker.getPassword());
        worker.setPassword(encodedPassword);

        repository.save(worker);
    }




    public void initiatePasswordReset(String emailOrUsername) {
        Optional<Worker> optionalWorker = repository.findByEmail(emailOrUsername);

        if (optionalWorker.isEmpty()) {
            throw new RuntimeException("Worker not found");
        }

        Worker worker = optionalWorker.get();
        String token = UUID.randomUUID().toString();
        worker.setResetToken(token);
        worker.setTokenExpiry(LocalDateTime.now().plusMinutes(15)); // token valid for 15 mins
        repository.save(worker);

        // TODO: Send email here (you can log it or just print for now)
        System.out.println("Reset token: " + token);
    }


    public void resetPassword(String token, String newPassword) {
        Optional<Worker> optionalWorker = repository.findByResetToken(token);

        if (optionalWorker.isEmpty()) {
            throw new RuntimeException("Invalid or expired token");
        }

        Worker worker = optionalWorker.get();

        if (worker.getTokenExpiry() == null || worker.getTokenExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expired");
        }

        String hashedPassword = passwordEncoder.encode(newPassword);
        worker.setPassword(hashedPassword);
        worker.setResetToken(null);
        worker.setTokenExpiry(null);

        repository.save(worker);
    }


}
