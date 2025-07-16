package com.example.SuiteIQ.server_hcm_controller.Finance_module_controllers;
import com.example.SuiteIQ.server_hcm_domain.PaymentMethod;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.PaymentMethodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-methods")

public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

        public PaymentMethodController(PaymentMethodService paymentMethodService) {
            this.paymentMethodService = paymentMethodService;
        }

        @GetMapping
        public List<PaymentMethod> getAllMethods() {
            return paymentMethodService.getAllMethods();
        }

        @PostMapping
        public PaymentMethod createMethod(@RequestBody PaymentMethod method) {
            return paymentMethodService.createMethod(method);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteMethod(@PathVariable Long id) {
            paymentMethodService.deleteMethod(id);
            return ResponseEntity.noContent().build();
        }
    }
