package com.example.Monster.controllers;

import com.example.Monster.dtos.ReviewRequest;
import com.example.Monster.dtos.ReviewResponse;
import com.example.Monster.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService=reviewService;
    }

    @GetMapping("/{productId}")
    public List<ReviewResponse> getReviews (@PathVariable ("productId") Long id){
        return reviewService.getReviewsByMonsterId(id);
    }

    @PostMapping("/{productId}")
    public ReviewResponse createReview (@PathVariable ("productId")Long id, @RequestBody ReviewRequest request){
        return reviewService.createReview(id, request);
    }
}
