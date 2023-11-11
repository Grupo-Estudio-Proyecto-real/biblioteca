package com.grupoJavaDiscord.biblioteca.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "issues")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cgender")   // Código del género
    private Long cgender;

    @Column(name =  "issue")    // Tema del libro
    private String issue;

    @Column(name = "subtopic")  // Subtema del libro
    private String subtopic;
}
