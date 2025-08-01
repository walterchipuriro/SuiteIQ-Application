package com.example.SuiteIQ.server_hcm_controller;

import com.example.SuiteIQ.dtos.LoginRequest;
import com.example.SuiteIQ.dtos.PasswordResetRequest;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.WorkerService;
import com.example.SuiteIQ.server_hcm_service.PasswordResetService;
import com.example.SuiteIQ.server_hcm_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private WorkerService workerService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        boolean authenticated = workerService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (authenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


//    For Gmail SMTP
        @Autowired
        private PasswordResetService resetService;

        @Autowired
        private UserService userService;

        @PostMapping("/forgot-password")
        public ResponseEntity<String> forgotPassword(@RequestParam String email) {
            resetService.initiateReset(email);
            return ResponseEntity.ok("Reset link sent to email");
        }

        @PostMapping("/reset-password")
        public ResponseEntity<String> resetPassword(
                @RequestParam String token,
                @RequestParam String newPassword
        ) {
            boolean result = resetService.resetPassword(token, newPassword, userService);
            return result
                    ? ResponseEntity.ok("Password reset successful")
                    : ResponseEntity.badRequest().body("Invalid or expired token");
        }


    // Step 1: Request password reset
    @PostMapping("/request-password-reset")
    public ResponseEntity<String> requestReset(@RequestBody PasswordResetRequest request) {
        // logic to send email
        return ResponseEntity.ok("Reset link sent.");
    }

    // Step 2: Reset password using token
    @PostMapping("/api/auth/confirm-reset")
    public <ResetPasswordRequest> ResponseEntity<?> confirmReset(@RequestBody ResetPasswordRequest req) {
        // validate token, check expiry, update password
        // ...
        return ResponseEntity.ok("Password updated");
    }

}


