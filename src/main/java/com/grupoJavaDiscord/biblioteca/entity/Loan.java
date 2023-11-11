package com.grupoJavaDiscord.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloan")
    private Long cloan;         // Código préstamo

    @Column(name = "cuser")
    private Long cuser;         // Código usuario

    @Column(name = "cbook")
    private Long cbook;         // Código libro

    @Column(name = "floan")
    private String floan;       // Fecha del préstamo

    @Column(name = "daysloan")
    private Integer daysloan;   // Dias totales de préstamo

}
