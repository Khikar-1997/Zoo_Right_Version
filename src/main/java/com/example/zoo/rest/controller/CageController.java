package com.example.zoo.rest.controller;

import com.example.zoo.rest.model.cage.CageRequestModel;
import com.example.zoo.rest.model.cage.CageResponseModel;
import com.example.zoo.service.CageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CageController {
    private final CageService cageService;

    public CageController(CageService cageService) {
        this.cageService = cageService;
    }

    @PostMapping(value = "/cage")
    public ResponseEntity create(@RequestBody CageRequestModel cageRequestModel){
        CageResponseModel cage = cageService.create(cageRequestModel);
        return ResponseEntity.ok(cage);
    }

    @GetMapping(value = "/cage")
    public ResponseEntity<List<CageResponseModel>> selectAllCages(){
        List<CageResponseModel> cages = cageService.selectAllCages();
        return ResponseEntity.ok(cages);
    }

    @GetMapping(value = "/cage/{id}")
    public ResponseEntity<CageResponseModel> findCageById(@PathVariable Long id){
        CageResponseModel cage = cageService.findCageById(id);
        return ResponseEntity.ok(cage);
    }

    @PutMapping(value = "/cage/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody CageRequestModel cageRequestModel){
        CageResponseModel cage = cageService.update(id,cageRequestModel);
        return ResponseEntity.ok(cage);
    }

    @DeleteMapping(value = "/cage/{id}")
    public void delete(@PathVariable Long id){
        cageService.delete(id);
    }
}
