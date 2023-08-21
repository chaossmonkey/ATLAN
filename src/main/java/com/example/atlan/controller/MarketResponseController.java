package com.example.atlan.controller;

import com.example.atlan.entity.FlaggedResponse;
import com.example.atlan.entity.MarketResponse;
import com.example.atlan.repository.FlaggedResponseRepository;
import com.example.atlan.repository.MarketResponseRepository;
import com.example.atlan.repository.ResponseRepository;
import com.example.atlan.service.MarketFlagResponseService;
import com.example.atlan.service.MarketResponseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responses")
public class MarketResponseController {

    @Autowired
    private MarketResponseRepository marketResponseRepository;

    @Autowired
    private FlaggedResponseRepository flaggedResponseRepository;

    @Autowired
    private MarketResponseValidator responseValidator;

    @Autowired
    private MarketFlagResponseService flaggedResponseService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitResponse(@RequestBody MarketResponse marketResponse) {
        // Validate the response using the custom validator
        if (!responseValidator.isValid(marketResponse)) {
            // If the response is not valid, create a flagged response entity
            FlaggedResponse flaggedResponse = new FlaggedResponse();
            flaggedResponse.setMarketResponse(marketResponse);
            flaggedResponse.setFlagReason("Monthly savings exceed monthly income.");
            flaggedResponse.setFeedback("Please correct your response.");

            // Save the flagged response to the database
            flaggedResponseRepository.save(flaggedResponse);

            // Return a message to inform the data collector
            return ResponseEntity.badRequest().body("Response is not valid. Please fix the issues.");
        }

        // Save the valid response to the database
        marketResponseRepository.save(marketResponse);

        return ResponseEntity.ok("Response submitted successfully.");
    }


    @GetMapping("/by-reason/{reason}")
    public ResponseEntity<List<FlaggedResponse>> getFlaggedResponsesByReason(@PathVariable String reason) {
        List<FlaggedResponse> flaggedResponses = flaggedResponseService.getFlaggedResponsesByReason(reason);

        if (flaggedResponses.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(flaggedResponses);
    }
}

