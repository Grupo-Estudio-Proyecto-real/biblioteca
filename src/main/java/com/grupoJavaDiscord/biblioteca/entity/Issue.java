package com.grupoJavaDiscord.biblioteca.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "issues",
        catalog = "biblioteca")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cgender", length = 4)
    private Long cgender;

    @Column(name =  "issue", nullable = false, length = 20)
    private String issue;

    @Column(name = "subtopic", length = 20)
    private String subtopic;

    @OneToMany(mappedBy = "issue")
    private List<Book> books;
}
