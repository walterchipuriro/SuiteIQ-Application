package com.example.SuiteIQ.server_hcm_service;

import com.example.SuiteIQ.server_hcm_domain.PasswordResetToken;
import com.example.SuiteIQ.server_hcm_repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class PasswordResetService {

    @Autowired
    private PasswordResetTokenRepository tokenRepo;

    @Autowired
    private MailService mailService;

    public void initiateReset(String email) {
        // 1. Generate token
        String token = UUID.randomUUID().toString();

        // 2. Save token (15 min expiry)
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setToken(token);
        resetToken.setEmail(email);
        resetToken.setExpiryDate(LocalDateTime.now().plusMinutes(15));
        tokenRepo.deleteByEmail(email); // Clean old tokens
        tokenRepo.save(resetToken);

        // 3. Send email
        String resetLink = "http://localhost:3000/reset-password?token=" + token;
        mailService.sendResetEmail(email, resetLink);
    }

    public boolean resetPassword(String token, String newPassword, UserService userService) {
        Optional<PasswordResetToken> tokenOptional = tokenRepo.findByToken(token);
        if (tokenOptional.isPresent()) {
            PasswordResetToken resetToken = tokenOptional.get();

            if (resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
                return false; // Token expired
            }

            userService.updatePasswordByEmail(resetToken.getEmail(), newPassword); // Implement this
            tokenRepo.delete(resetToken);
            return true;
        }

        return false;
    }
}

