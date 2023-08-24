package com.example.atlan.controller;


import com.example.atlan.entity.Slang;
import com.example.atlan.repository.SlangRepository;
import com.example.atlan.service.SlangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/slangs")
class SlangController {

    private final SlangRepository slangRepository;

    private final SlangService service;

    @Autowired
    public SlangController(SlangRepository slangRepository, SlangService service) {
        this.slangRepository = slangRepository;
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Slang> createSlang(@RequestBody Slang slang) {
        try {
            Slang createdSlang = slangRepository.save(slang);
            return new ResponseEntity<>(createdSlang, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{slangId}")
    public ResponseEntity<Slang> getSlangById(@PathVariable Long slangId) {
        Optional<Slang> slangData = slangRepository.findById(slangId);

        return slangData.map(slang -> new ResponseEntity<>(slang, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/{slangId}")
    public ResponseEntity<Slang> updateSlang(@PathVariable Long slangId, @RequestBody Slang slang) {
        Optional<Slang> slangData = slangRepository.findById(slangId);

        if (slangData.isPresent()) {
            Slang updatedSlang = slangData.get();
            updatedSlang.setSlangText(slang.getSlangText());

            return new ResponseEntity<>(slangRepository.save(updatedSlang), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{slangId}")
    public ResponseEntity<HttpStatus> deleteSlang(@PathVariable Long slangId) {
        try {
            slangRepository.deleteById(slangId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<String>> searchSlangsByCity(@RequestParam Long cityId) {
        List<String> slangs = service.getSlangsByCity(cityId);
        return ResponseEntity.ok(slangs);
    }




}
