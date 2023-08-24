package com.example.atlan.repository;

import com.example.atlan.entity.FlaggedResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlaggedResponseRepository extends JpaRepository<FlaggedResponse, Long> {
    List<FlaggedResponse> findByBusinessRuleId(Long ruleId);
}
