package com.example.SuiteIQ.server_hcm_service;

import com.example.SuiteIQ.server_hcm_domain.Reviews;
import com.example.SuiteIQ.server_hcm_domain.Reviews;

import java.util.List;

public interface ReviewsService {
    Reviews createReview(Reviews reviews);
    List<Reviews> getAllReviews();
    Reviews getReviewById(Long id);
    List<Reviews> getReviewsByRoom(Long roomId);
    List<Reviews> getReviewsByUser(Long userId);
    void deleteReview(Long id);
    Reviews updateReview(Long id, Reviews updatedReview);
}

