package com.example.atlan.controller;

import com.example.atlan.entity.Response;
import com.example.atlan.repository.ResponseRepository;
import com.example.atlan.service.PostSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private PostSubmissionService postSubmissionService;

    @Autowired
    private ResponseRepository responseRepository;

    @PostMapping("/submit")
    public ResponseEntity<String> submitResponse(@RequestBody Response response) {
        // Validate and save the response
        responseRepository.save(response);

        // Trigger post-submission processing
        postSubmissionService.processResponse(response);

        return ResponseEntity.ok("Response submitted successfully.");
    }
}

