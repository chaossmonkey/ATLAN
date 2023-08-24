package com.example.atlan.controller;

import com.example.atlan.entity.City;
import com.example.atlan.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/api/cities")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City createdCity = cityService.createCityWithSlangs(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
    }

}
