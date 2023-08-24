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
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formId;

    private String formName;

    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "creator_user_id")
    private User creator;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "form")
    private List<Response> responses;


    @ManyToMany
    @JoinTable(
            name = "form_business_rule",
            joinColumns = @JoinColumn(name = "form_id"),
            inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private List<BusinessRule> businessRules;
}
