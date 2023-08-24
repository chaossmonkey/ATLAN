package com.example.atlan.repository;

import com.example.atlan.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {
    // You can define custom query methods here if needed
}

