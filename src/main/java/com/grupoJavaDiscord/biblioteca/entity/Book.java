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
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cbook")
    private Long cbook;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "isbn", unique = true)
    private String isbn;

    @Column(name = "authors")
    private String authors;

    @Column(name = "dedition")
    private String dedition;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cgender")
    private Issue issue;

    //    @Column(name = "cgender")
    //    private Long cgender;

    @Column(name = "summary")       // Brief book summary
    private String summary;

    @Column(name = "frontpage")     // Name of the book cover image
    private String frontpage;

    @Column(name = "pathbook")      // Path and name of virtual book
    private String pathbook;

    @Column(name = "availability")  // Libro disponible: (D)isponible, (P)restado, (F)uera de servicio
    @Enumerated(EnumType.STRING)
    private Availability availability;
}
