package com.example.atlan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusinessRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruleId;
    private String ruleName;
    private String description;
    private String ruleExpression; // Expression to evaluate the rule (e.g., monthlySavings > monthlyIncome)

    @ManyToMany(mappedBy = "businessRules")
    private List<Form> forms;

    @ManyToMany(mappedBy = "violatedRules")
    private List<Response> responses;


    // Getters and setters
}
