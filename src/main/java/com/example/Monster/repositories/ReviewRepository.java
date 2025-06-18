package com.example.Monster.repositories;

import com.example.Monster.models.Monster;
import com.example.Monster.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByMonster(Monster monster);
}
