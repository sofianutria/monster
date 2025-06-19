package com.example.Monster.services;

import com.example.Monster.dtos.MonsterMapper;
import com.example.Monster.dtos.MonsterRequest;
import com.example.Monster.dtos.MonsterResponse;
import com.example.Monster.models.Monster;
import com.example.Monster.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    public List<Monster> getAllMonsters(){
        return monsterRepository.findAll();
    }

    public MonsterResponse getMonsterById(Long id){
        return monsterRepository.findById(id)
                .map(MonsterMapper::toResponse)
                .orElseThrow(()-> new RuntimeException("Monster not found"));
    }

    public MonsterResponse createMonster (MonsterRequest request){
        Monster monster = MonsterMapper.toEntity(request);
        return MonsterMapper.toResponse(monsterRepository.save(monster));
    }

    public MonsterResponse updateMonster (Long id, MonsterRequest request){
        Monster monster = monsterRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Monster not found"));
        monster.setName (request.getName());
        monster.setPrice (request.getPrice());
        monster.setImageUrl (request.getImageUrl());
        monster.setRating (request.getRating());
        monster.setReviewCount (request.getReviewCount());
        monster.setFeatured (request.isFeatured());
        return MonsterMapper.toResponse(monsterRepository.save(monster));
    }

    public void deleteMonster(Long id){
        monsterRepository.deleteById(id);
    }

}
