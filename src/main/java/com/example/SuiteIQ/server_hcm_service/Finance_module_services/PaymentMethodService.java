package com.example.SuiteIQ.server_hcm_service.Finance_module_services;

import com.example.SuiteIQ.server_hcm_domain.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {

        List<PaymentMethod> getAllMethods();
        PaymentMethod createMethod(PaymentMethod method);
        void deleteMethod(Long id);
    }

