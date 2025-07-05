package com.example.SuiteIQ.server_hcm_service;

import com.example.SuiteIQ.server_hcm_domain.Reviews;
import com.example.SuiteIQ.server_hcm_repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    private ReviewsRepository repository;

    @Override
    public Reviews createReview(Reviews review) {
        return repository.save(review);
    }

    @Override
    public List<Reviews> getAllReviews() {
        return repository.findAll();
    }

    @Override
    public Reviews getReviewById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Reviews> getReviewsByRoom(Long roomId) {
        return repository.findByRoomId(roomId);
    }

    @Override
    public List<Reviews> getReviewsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void deleteReview(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Reviews updateReview(Long id, Reviews updatedReview) {
        return repository.findById(id).map(existing -> {
            existing.setUserId(updatedReview.getUserId());
            existing.setRoomId(updatedReview.getRoomId());
            existing.setRating(updatedReview.getRating());
            existing.setComment(updatedReview.getComment());
            existing.setTimestamp(updatedReview.getTimestamp());
            return repository.save(existing);
        }).orElse(null);
    }
}
