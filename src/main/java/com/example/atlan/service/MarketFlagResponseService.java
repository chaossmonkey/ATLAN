package com.example.atlan.service;

import com.example.atlan.entity.FlaggedResponse;
import com.example.atlan.repository.FlaggedResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MarketFlagResponseService {

    @Autowired
    private FlaggedResponseRepository flaggedResponseRepository;

    public List<FlaggedResponse> getFlaggedResponsesByReason(String reason) {
        return flaggedResponseRepository.findByFlagReason(reason);
    }
}
