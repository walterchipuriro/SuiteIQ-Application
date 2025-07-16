package com.example.SuiteIQ.server_hcm_controller.Finance_module_controllers;


import com.example.SuiteIQ.server_hcm_domain.Payment;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

        private final PaymentService paymentService;

        public PaymentController(PaymentService paymentService) {
            this.paymentService = paymentService;
        }

        @GetMapping
        public List<Payment> getAllPayments() {
            return paymentService.getAllPayments();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
            return ResponseEntity.of(paymentService.getPaymentById(id));
        }

        @PostMapping
        public Payment createPayment(@RequestBody Payment payment) {
            return paymentService.createPayment(payment);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
            return ResponseEntity.of(paymentService.updatePayment(id, payment));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
            paymentService.deletePayment(id);
            return ResponseEntity.noContent().build();
        }
    }
