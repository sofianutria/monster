package com.example.Monster.services;

import com.example.Monster.dtos.MonsterMapper;
import com.example.Monster.dtos.MonsterResponse;
import com.example.Monster.repositories.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    public List<MonsterResponse> getAllMonsters(){
        return monsterRepository.findAll().stream()
                .map(MonsterMapper::toResponse)
                .collect(Collectors.toList());
    }
}
