package com.example.SuiteIQ.server_hcm_controller.Finance_module_controllers;

import com.example.SuiteIQ.server_hcm_domain.Receipt;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receipts")

public class ReceiptController {

        private final ReceiptService receiptService;

        public ReceiptController(ReceiptService receiptService) {
            this.receiptService = receiptService;
        }

        @GetMapping
        public List<Receipt> getAllReceipts() {
            return receiptService.getAllReceipts();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Receipt> getReceiptById(@PathVariable Long id) {
            return ResponseEntity.of(receiptService.getReceiptById(id));
        }

        @PostMapping
        public Receipt createReceipt(@RequestBody Receipt receipt) {
            return receiptService.createReceipt(receipt);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Receipt> updateReceipt(@PathVariable Long id, @RequestBody Receipt receipt) {
            return ResponseEntity.of(receiptService.updateReceipt(id, receipt));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteReceipt(@PathVariable Long id) {
            receiptService.deleteReceipt(id);
            return ResponseEntity.noContent().build();
        }
    }
