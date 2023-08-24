package com.example.atlan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responseId;
    private Date submissionDate;

    // Many-to-One relationship with User (user who submitted the response)
    @ManyToOne
    @JoinColumn(name = "responder_user_id")
    private User responder;

    // Many-to-One relationship with Form (the form responded to)
    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;

    // One-to-Many relationship with Answers
    @OneToMany(mappedBy = "response", cascade = CascadeType.ALL)
    private List<Answer> answers;

    @OneToMany(mappedBy = "response", cascade = CascadeType.ALL)
    private List<FlaggedResponse> flaggedResponses;



    @ManyToMany
    @JoinTable(
            name = "response_violated_rules",
            joinColumns = @JoinColumn(name = "response_id"),
            inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private List<BusinessRule> violatedRules;



    // Method to check and flag violated rules
    public void checkBusinessRules() {
        for (BusinessRule rule : form.getBusinessRules()) {
            String ruleExpression = rule.getRuleExpression();
            // Evaluate the rule expression (e.g., monthlySavings > monthlyIncome)
            // If the rule is violated, add it to the violated rules list.
            if (evaluateRuleExpression(ruleExpression)) {
                violatedRules.add(rule);
            }
        }
    }


    public List<BusinessRule> getFlaggedRules() {
        return violatedRules;
    }
    private boolean evaluateRuleExpression(String expression) {
        // Implement logic to evaluate the rule expression (e.g., using a scripting engine).
        // For simplicity, assume the rule is always violated in this example.
        return true;
    }
}

