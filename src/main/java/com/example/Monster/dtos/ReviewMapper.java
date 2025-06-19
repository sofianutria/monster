package com.example.Monster.dtos;

import com.example.Monster.models.Monster;
import com.example.Monster.models.Review;

public class ReviewMapper {
    public static ReviewResponse toResponse (Review review){
        ReviewResponse response = new ReviewResponse();
        response.setId(review.getId());
        response.setUsername(review.getUsername());
        response.setRating(review.getRating());
        response.setBody(review.getBody());
        return response;
    }

    public static Review toEntity (ReviewRequest request, Monster monster){
        Review review = new Review();
        review.setId(request.getId());
        review.setUsername(request.getUsername());
        review.setRating(request.getRating());
        review.setBody(request.getBody());
        review.setMonster(monster);
        return review;
    }
}
