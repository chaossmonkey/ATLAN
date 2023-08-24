package com.example.atlan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Slang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slangId;

    private String slangText;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
