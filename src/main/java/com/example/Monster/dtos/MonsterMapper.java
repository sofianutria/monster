package com.example.Monster.dtos;

import com.example.Monster.models.Monster;

public class MonsterMapper {
    public static Monster toEntity(MonsterRequest request){
        Monster monster = new Monster();
        monster.setName (request.getName());
        monster.setPrice (request.getPrice());
        monster.setImageUrl (request.getImageUrl());
        monster.setRating (request.getRating());
        monster.setReviewCount (request.getReviewCount());
        monster.setFeatured (request.isFeatured());
        return monster;
    }
    public static MonsterResponse toResponse (Monster monster){
        MonsterResponse response = new MonsterResponse();
        response.setId(monster.getId());
        response.setName (monster.getName());
        response.setPrice (monster.getPrice());
        response.setImageUrl (monster.getImageUrl());
        response.setRating (monster.getRating());
        response.setReviewCount (monster.getReviewCount());
        response.setFeatured (monster.isFeatured());
        return response;
    }
}
