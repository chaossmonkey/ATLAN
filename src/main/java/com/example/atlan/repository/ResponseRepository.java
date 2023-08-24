package com.example.atlan.repository;

import com.example.atlan.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
    // You can define custom query methods here if needed
}
