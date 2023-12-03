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
@Table(name = "loans",
        catalog = "biblioteca")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cloan", length = 8)
    private Long cloan;                 // Código préstamo

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cuser", referencedColumnName = "cuser", foreignKey = @ForeignKey(name = "FK_LOANS_USER"))
    private User user;                  // User code.

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cbook", referencedColumnName = "cbook", foreignKey = @ForeignKey(name = "FK_LOAN_BOOK"))
    private Book book;                  // Book code.

    @Column(name = "floan", length = 10)
    private String floan;               // Date of loan

    @Column(name = "daysloan")
    private Integer daysloan;           // Total days of loan

}
