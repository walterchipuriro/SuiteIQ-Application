package com.example.SuiteIQ.server_hcm_service.Finance_module_services;

import com.example.SuiteIQ.server_hcm_domain.Receipt;

import java.util.List;
import java.util.Optional;

public interface ReceiptService {
    
        List<Receipt> getAllReceipts();
        Optional<Receipt> getReceiptById(Long id);
        Receipt createReceiptForPayment(Long paymentId); // auto-generates receipt
        Optional<Receipt> updateReceipt(Long id, Receipt receipt);
        void deleteReceipt(Long id);

        // Optional:
        Receipt getReceiptByBookingId(Long bookingId);
        String generateReceiptText(Long receiptId); // generates printable text or PDF

    Receipt createReceipt(Receipt receipt);
}
    
