package com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories;


import com.example.SuiteIQ.server_hcm_domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    // Optional: search by username or role
    // Optional<Worker> findByUsername(String username);
}
