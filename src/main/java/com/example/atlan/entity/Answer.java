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
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;
    private String answerText;

    // Many-to-One relationship with Question (the question to which this is an answer)
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // Many-to-One relationship with Response (the response to which this answer belongs)
    @ManyToOne
    @JoinColumn(name = "response_id")
    private Response response;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city; // Associate the answer with a city (optional)


}
