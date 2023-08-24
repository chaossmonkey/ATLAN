package com.example.atlan.repository;

import com.example.atlan.entity.Slang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlangRepository extends JpaRepository<Slang, Long> {
    // You can define custom query methods here if

    List<Slang> findByCityCityId(Long cityId);
}
