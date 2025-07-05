package com.example.SuiteIQ.server_hcm_controller.Finance_module_controllers;

import com.example.SuiteIQ.server_hcm_domain.Reviews;
import com.example.SuiteIQ.server_hcm_service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewService;

    @PostMapping
    public Reviews create(@RequestBody Reviews reviews) {
        return reviewService.createReview(reviews);
    }

    @GetMapping
    public List<Reviews> getAll() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Reviews getById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @GetMapping("/room/{roomId}")
    public List<Reviews> getByRoom(@PathVariable Long roomId) {
        return reviewService.getReviewsByRoom(roomId);
    }

    @GetMapping("/user/{userId}")
    public List<Reviews> getByUser(@PathVariable Long userId) {
        return reviewService.getReviewsByUser(userId);
    }

    @PutMapping("/{id}")
    public Reviews update(@PathVariable Long id, @RequestBody Reviews review) {
        return reviewService.updateReview(id, review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}

