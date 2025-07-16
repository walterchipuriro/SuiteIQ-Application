package com.example.SuiteIQ.server_hcm_controller.Finance_module_controllers;

import com.example.SuiteIQ.server_hcm_domain.Worker;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
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
        public Worker createWorker(@RequestBody Worker worker) {
            return workerService.createWorker(worker);
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
    }
