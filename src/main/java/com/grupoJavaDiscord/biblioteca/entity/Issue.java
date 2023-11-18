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
    @Column(name = "cgender")
    private Long cgender;

    @Column(name =  "issue")
    private String issue;

    @Column(name = "subtopic")
    private String subtopic;
}
