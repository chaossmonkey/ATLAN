package com.example.atlan.controller;

import com.example.atlan.entity.Slang;
import com.example.atlan.repository.SlangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/slangs")
public class SlangController {

    @Autowired
    private SlangRepository slangRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addSlang(@RequestBody Slang slang) {
        // Validate and save the new slang
        slangRepository.save(slang);
        return ResponseEntity.ok("Slang added successfully.");
    }
}
