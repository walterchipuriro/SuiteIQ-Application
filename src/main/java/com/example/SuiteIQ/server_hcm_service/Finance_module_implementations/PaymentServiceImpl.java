package com.example.SuiteIQ.server_hcm_service.Finance_module_implementations;
import com.example.SuiteIQ.server_hcm_domain.Payment;
import com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories.PaymentRepository;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.PaymentService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }


    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> updatePayment(Long id, Payment updatedPayment) {
        return paymentRepository.findById(id).map(existing -> {
            existing.setAmount(updatedPayment.getAmount());
//            existing.setPaymentDate();Date(updatedPayment.getPaymentDate());
            existing.setPaymentDate(updatedPayment.getPaymentDate());

            existing.setBooking(updatedPayment.getBooking());
            existing.setWorker(updatedPayment.getWorker());
            existing.setPaymentMethod(updatedPayment.getPaymentMethod());
            return paymentRepository.save(existing);
        });
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> getPaymentsByWorker(Long workerId) {
        return paymentRepository.findByWorkerId(workerId);
    }

    @Override
    public List<Payment> getPaymentsByPaymentDate(LocalDate date) {
        return List.of();
    }


    @Override
    public double getTotalPaymentsForDate(LocalDate date) {
        return 0;
    }

    @Override
    public boolean isBookingPaid(Long bookingId) {
        return !paymentRepository.findByBooking_Id(bookingId).isEmpty();
    }
}
