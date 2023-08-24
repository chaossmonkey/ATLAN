package com.example.atlan.repository;

import com.example.atlan.entity.BusinessRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRuleRepository extends JpaRepository<BusinessRule, Long> {
    // You can define custom query methods here if needed
}

