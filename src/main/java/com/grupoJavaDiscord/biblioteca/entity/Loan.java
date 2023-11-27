package com.grupoJavaDiscord.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloan")
    private Long cloan;         // Código préstamo

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cuser")
    private User user;           // User code.

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cbook")
    private Book book;          // Book code.

    @Column(name = "floan")
    private String floan;       // Fecha del préstamo

    @Column(name = "daysloan")
    private Integer daysloan;   // Dias totales de préstamo

}
