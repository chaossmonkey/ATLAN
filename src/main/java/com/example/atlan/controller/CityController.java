package com.example.atlan.controller;

import com.example.atlan.entity.City;
import com.example.atlan.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addCity(@RequestBody City city) {
        // Validate and save the new city
        cityRepository.save(city);
        return ResponseEntity.ok("City added successfully.");
    }
}
