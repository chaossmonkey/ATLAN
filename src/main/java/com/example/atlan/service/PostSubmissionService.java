package com.example.atlan.service;

import com.example.atlan.entity.Response;
import com.example.atlan.repository.CitySlangRepository;
import com.example.atlan.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSubmissionService {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private CitySlangRepository citySlangRepository;

    public void processResponse(Response response) {
        String cityAnswer = response.getCityAnswer();

        // Query the database to get slangs associated with the city
        List<String> matchingSlangs = citySlangRepository.findSlangsByCityName(cityAnswer);

        // Store or use matching slangs
        System.out.println("Matching slangs for " + cityAnswer + ": " + matchingSlangs);
    }
}
