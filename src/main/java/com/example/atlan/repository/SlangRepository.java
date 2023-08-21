package com.example.atlan.repository;

import com.example.atlan.entity.Slang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlangRepository extends JpaRepository<Slang, Long> {
}