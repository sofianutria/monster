package com.example.Monster.controllers;

import com.example.Monster.models.Monster;
import com.example.Monster.repositories.MonsterRepository;
import com.example.Monster.services.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins="http://localhost:5173")

public class MonsterController {
    @Autowired
    private MonsterService monsterService;

    @GetMapping
    public List<Monster> getAllMonsters(){
        return monsterService.findAll();
    }


}
