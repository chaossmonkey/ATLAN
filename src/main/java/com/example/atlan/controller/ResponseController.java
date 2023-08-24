package com.example.atlan.controller;

import com.example.atlan.entity.BusinessRule;
import com.example.atlan.entity.FlaggedResponse;
import com.example.atlan.entity.Response;
import com.example.atlan.repository.FlaggedResponseRepository;
import com.example.atlan.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {
    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private FlaggedResponseRepository flaggedResponseRepository;

    // ...

    // Endpoint to validate responses against business rules and store flagged responses
    @PostMapping("/validate")
    public ResponseEntity<?> validateResponses() {
        List<Response> responses = responseRepository.findAll();

        for (Response response : responses) {
            response.checkBusinessRules();

            // Check for flagged rules and store in the FlaggedResponse table
            for (BusinessRule rule : response.getFlaggedRules()) {
                FlaggedResponse flaggedResponse = new FlaggedResponse();
                flaggedResponse.setResponse(response);
                flaggedResponse.setBusinessRule(rule);
                flaggedResponseRepository.save(flaggedResponse);
            }

            responseRepository.save(response);
        }

        return ResponseEntity.ok("Responses validated and flagged.");
    }

    // ...

    // Endpoint to fetch flagged responses based on a certain rule
    @GetMapping("/flagged/{ruleId}")
    public ResponseEntity<List<FlaggedResponse>> getFlaggedResponsesByRule(@PathVariable Long ruleId) {
        List<FlaggedResponse> flaggedResponses = flaggedResponseRepository.findByBusinessRuleId(ruleId);
        return ResponseEntity.ok(flaggedResponses);
    }
}
