package com.example.SuiteIQ.server_hcm_service.Finance_module_implementations;

import com.example.SuiteIQ.server_hcm_domain.Payment;
import com.example.SuiteIQ.server_hcm_domain.Receipt;
import com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories.PaymentRepository;
import com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories.ReceiptRepository;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.ReceiptService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final PaymentRepository paymentRepository;
    private final com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories.ReceiptRepository ReceiptRepository;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, PaymentRepository paymentRepository, com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories.ReceiptRepository receiptRepository1) {
        ReceiptRepository = receiptRepository1;
        this.receiptRepository = ReceiptRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    @Override
    public Optional<Receipt> getReceiptById(Long id) {
        return receiptRepository.findById(id);
    }

    @Override
    public Receipt createReceiptForPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("Payment not found"));

        Receipt receipt = new Receipt();
        receipt.setPayment(payment);
        receipt.setBooking(payment.getBooking());
        receipt.setIssueDate(LocalDate.now());
        receipt.setAmount(payment.getAmount());

        return receiptRepository.save(receipt);
    }

    @Override
    public Optional<Receipt> updateReceipt(Long id, Receipt updated) {
        return receiptRepository.findById(id).map(existing -> {
            existing.setIssueDate(updated.getIssueDate());
            existing.setAmount(updated.getAmount());
            return receiptRepository.save(existing);
        });
    }

    @Override
    public void deleteReceipt(Long id) {
        receiptRepository.deleteById(id);
    }

    @Override
    public Receipt getReceiptByBookingId(Long bookingId) {
        return null;
    }

    @Override
    public String generateReceiptText(Long receiptId) {
        return "";
    }

    @Override
    public Receipt createReceipt(Receipt receipt) {
        return null;
    }
}


