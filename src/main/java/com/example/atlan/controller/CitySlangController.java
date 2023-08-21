package com.example.atlan.controller;

import com.example.atlan.entity.City;
import com.example.atlan.entity.CitySlang;
import com.example.atlan.entity.Slang;
import com.example.atlan.repository.CityRepository;
import com.example.atlan.repository.CitySlangRepository;
import com.example.atlan.repository.SlangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/city-slangs")
public class CitySlangController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private SlangRepository slangRepository;

    @Autowired
    private CitySlangRepository citySlangRepository;

    @PostMapping("/associate")
    public ResponseEntity<String> associateSlangWithCity(@RequestParam Long cityId, @RequestParam Long slangId) {
        // Find the city and slang entities
        Optional<City> city = cityRepository.findById(cityId);
        Optional<Slang> slang = slangRepository.findById(slangId);

        if (city.isPresent() && slang.isPresent()) {
            // Create a new CitySlang entity to associate the slang with the city
            CitySlang citySlang = new CitySlang();
            citySlang.setCity(city.get());
            citySlang.setSlang(slang.get());

            // Save the association
            citySlangRepository.save(citySlang);

            return ResponseEntity.ok("Slang associated with city successfully.");
        } else {
            return ResponseEntity.badRequest().body("City or slang not found.");
        }
    }
}
