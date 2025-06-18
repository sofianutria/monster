package com.example.Monster.repositories;

import com.example.Monster.models.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster,Long> {
}
