package com.example.atlan.repository;

import com.example.atlan.entity.FlaggedResponse;
import com.example.atlan.entity.MarketResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlaggedResponseRepository extends JpaRepository<FlaggedResponse, Long> {

    // Find all flagged responses for a specific marketResponse
    List<FlaggedResponse> findByMarketResponse(MarketResponse marketResponse);

    List<FlaggedResponse> findByFlagReason(String flagReason);
}
