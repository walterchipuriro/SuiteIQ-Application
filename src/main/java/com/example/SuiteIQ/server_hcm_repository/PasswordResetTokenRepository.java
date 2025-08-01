package com.example.SuiteIQ.server_hcm_repository;

import com.example.SuiteIQ.server_hcm_domain.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    Optional<PasswordResetToken> findByToken(String token);
    void deleteByEmail(String email);
}
