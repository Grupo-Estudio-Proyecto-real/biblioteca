package com.grupoJavaDiscord.biblioteca.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //Code of book, it's a number
    @Column(name = "cbook", length = 6)
    private Long cbook;

    @Column(name = "title", nullable = false, length = 80)      //The book' title
    private String title;

    @Column(name = "isbn", nullable = false, length = 17)       //Code of I.S.B.N.
    private String isbn;

    @Column(name = "authors", nullable = false, length = 80)    //Names of authors
    private String authors;

    @Column(name = "dedition", length = 10)                     //Date of edition
    private String dedition;

    @OneToOne(mappedBy = "book")
    private Loan loan;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cgender", referencedColumnName = "cgender", foreignKey = @ForeignKey(name = "FK_BOOKS_ISSUE"))
    private Issue issue;                                        //Code gender of book

    @Column(name = "summary", length = 255)                     // Brief book summary
    private String summary;

    @Column(name = "frontpage", length = 60)                    // Name of the book cover image
    private String frontpage;

    @Column(name = "pathbook", length = 200)                    // Path and name of virtual book
    private String pathbook;

    @Column(name = "availability", length = 1)                  // List status: (D)isponible, (P)restado, (F)uera de servicio
    @Enumerated(EnumType.STRING)
    private Availability availability;


}
