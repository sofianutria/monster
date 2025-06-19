package com.example.Monster.controllers;

import com.example.Monster.dtos.MonsterRequest;
import com.example.Monster.dtos.MonsterResponse;
import com.example.Monster.models.Monster;
import com.example.Monster.repositories.MonsterRepository;
import com.example.Monster.services.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins="http://localhost:5173")

public class MonsterController {
    @Autowired
    private MonsterService monsterService;

    @GetMapping
    public List<Monster> getAllMonsters(){
        return monsterService.getAllMonsters();
    }

    @GetMapping("/{id}")
    public MonsterResponse getMonsterById(@PathVariable Long id){
        return monsterService.getMonsterById(id);
    }

    @PostMapping
    public MonsterResponse createMonster (@RequestBody MonsterRequest request){
        return monsterService.createMonster(request);
    }

    @PutMapping("/{id}")
    public MonsterResponse updateMonsterById (@PathVariable Long id, @RequestBody MonsterRequest request){
        return monsterService.updateMonster(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonsterById (@PathVariable Long id){
        monsterService.deleteMonster(id);
        return ResponseEntity.noContent().build();
    }



}
