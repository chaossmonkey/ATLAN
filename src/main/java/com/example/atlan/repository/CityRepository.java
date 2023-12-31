package com.example.atlan.repository;

import com.example.atlan.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    // You can define custom query methods here if needed
}
