package com.example.SuiteIQ.server_hcm_repository;
import com.example.SuiteIQ.server_hcm_domain.Reviews;
import com.example.SuiteIQ.server_hcm_domain.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    List<Reviews> findByRoomId(Long roomId);
    List<Reviews> findByUserId(Long userId);
}
