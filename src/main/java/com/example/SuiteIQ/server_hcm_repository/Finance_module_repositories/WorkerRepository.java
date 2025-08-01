package com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories;

import com.example.SuiteIQ.server_hcm_domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {


    Optional<Worker> findByEmail(String email);

    Optional<Worker> findByUsername(String username);

    Optional<Worker> findByNationalId(String nationalId);

    Optional<Worker> findByUsernameAndPassword(String username, String password);

    Optional<Worker> findByResetToken(String resetToken);

}
