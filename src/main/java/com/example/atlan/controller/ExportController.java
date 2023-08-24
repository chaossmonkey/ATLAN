package com.example.atlan.controller;

import com.example.atlan.service.GoogleSheetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/export")
public class ExportController {

    private final GoogleSheetsService sheetsService;

    @Autowired
    public ExportController(GoogleSheetsService sheetsService) {
        this.sheetsService = sheetsService;
    }

    @PostMapping("/toGoogleSheets")
    public ResponseEntity<String> exportToGoogleSheets(@RequestBody List<List<Object>> data) {
        try {
            sheetsService.writeToGoogleSheets(data);
            return ResponseEntity.ok("Data exported to Google Sheets successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error exporting data to Google Sheets.");
        }
    }
}
