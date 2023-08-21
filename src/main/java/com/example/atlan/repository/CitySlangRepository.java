package com.example.atlan.repository;


import com.example.atlan.entity.CitySlang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitySlangRepository extends JpaRepository<CitySlang, Long> {

    @Query("SELECT cs.slang.text FROM CitySlang cs WHERE cs.city.name = :cityName")
    List<String> findSlangsByCityName(@Param("cityName") String cityName);
}
