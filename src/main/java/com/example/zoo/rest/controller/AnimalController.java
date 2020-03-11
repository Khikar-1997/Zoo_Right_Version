package com.example.zoo.rest.controller;

import com.example.zoo.rest.model.animal.AnimalRequestModel;
import com.example.zoo.rest.model.animal.AnimalResponseModel;
import com.example.zoo.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping(value = "/animal")
    public ResponseEntity create(@RequestBody AnimalRequestModel animalRequestModel){
        AnimalResponseModel animal = animalService.create(animalRequestModel);
        return ResponseEntity.ok(animal);
    }
}
