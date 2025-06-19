package com.example.Monster.services;

import com.example.Monster.dtos.ReviewMapper;
import com.example.Monster.dtos.ReviewRequest;
import com.example.Monster.dtos.ReviewResponse;
import com.example.Monster.models.Monster;
import com.example.Monster.models.Review;
import com.example.Monster.repositories.MonsterRepository;
import com.example.Monster.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MonsterRepository monsterRepository;

    public ReviewService(ReviewRepository reviewRepository, MonsterRepository monsterRepository) {
        this.reviewRepository = reviewRepository;
        this.monsterRepository = monsterRepository;
    }

    public List<ReviewResponse> getReviewsByMonsterId(Long productId){
        Monster monster = monsterRepository.findById(productId)
        .orElseThrow(() -> new RuntimeException("Monster not found"));
        return reviewRepository.findByMonster(monster)
                .stream()
                .map(ReviewMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ReviewResponse createReview (Long productId, ReviewRequest request){
        Monster monster = monsterRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Monster not found"));
        Review review =ReviewMapper.toEntity(request, monster);
        reviewRepository.save(review);
        updateMonsterRating(monster);
        return  ReviewMapper.toResponse(review);
    }

    private void updateMonsterRating(Monster monster){
        List<Review> reviews = reviewRepository.findByMonster(monster);
        double avgRating=reviews.stream().mapToDouble(Review::getRating).average().orElse(0);
        monster.setRating(avgRating);
        monster.setReviewCount(reviews.size());
        monsterRepository.save(monster);
    }
}
