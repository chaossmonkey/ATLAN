package com.example.atlan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlaggedResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flaggedResponseId;

    @ManyToOne
    @JoinColumn(name = "response_id")
    private Response response;

    @ManyToOne
    @JoinColumn(name = "business_rule_id")
    private BusinessRule businessRule;


}
