package com.example.SuiteIQ.server_hcm_service.Finance_module_implementations;

import com.example.SuiteIQ.server_hcm_domain.PaymentMethod;
import com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories.PaymentMethodRepository;
import com.example.SuiteIQ.server_hcm_service.Finance_module_services.PaymentMethodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository repository;

    public PaymentMethodServiceImpl(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PaymentMethod> getAllMethods() {
        return repository.findAll();
    }

    @Override
    public PaymentMethod createMethod(PaymentMethod method) {
        return repository.save(method);
    }

    @Override
    public void deleteMethod(Long id) {
        repository.deleteById(id);
    }
}
