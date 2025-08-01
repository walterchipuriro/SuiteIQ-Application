package com.example.SuiteIQ.server_hcm_controller.Finance_module_controllers;

import com.example.SuiteIQ.dtos.LoginRequest;
import com.example.SuiteIQ.server_hcm_domain.Worker;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
        return ResponseEntity.of(workerService.getWorkerById(id));
    }

    @PostMapping
    public ResponseEntity<?> createWorker(@RequestBody Worker worker) {
        try {
            Worker created = workerService.createWorker(worker);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worker> updateWorker(@PathVariable Long id, @RequestBody Worker worker) {
        return ResponseEntity.of(workerService.updateWorker(id, worker));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean authenticated = workerService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (authenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    @Autowired
    private WorkerService WorkerService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Worker worker) {
        workerService.registerWorker(worker);
        return ResponseEntity.ok("Worker registered successfully");
    }


    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> payload) {
        String emailOrUsername = payload.get("usernameOrEmail");
        try {
            workerService.initiatePasswordReset(emailOrUsername);
            return ResponseEntity.ok("Reset token sent (check logs for now)");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> payload) {
        String token = payload.get("token");
        String newPassword = payload.get("newPassword");

        try {
            workerService.resetPassword(token, newPassword);
            return ResponseEntity.ok("Password successfully updated.");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


}
