package com.example.SuiteIQ.server_hcm_repository.Finance_module_repositories;


import com.example.SuiteIQ.server_hcm_domain.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    Optional<PaymentMethod> findByMethod(String method);
}
