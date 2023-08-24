package com.example.atlan.service;

import com.example.atlan.entity.City;
import com.example.atlan.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City createCityWithSlangs(City city) {

        return cityRepository.save(city);
    }
}
