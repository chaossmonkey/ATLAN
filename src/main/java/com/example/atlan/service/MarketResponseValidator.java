package com.example.atlan.service;

import com.example.atlan.entity.MarketResponse;

public class MarketResponseValidator { public boolean isValid(MarketResponse response) {
    // Implement your business rules validation logic here
    // For example, check if monthly savings are more than monthly income
    return response.getMonthlySavings() <= response.getMonthlyIncome();
}


}
