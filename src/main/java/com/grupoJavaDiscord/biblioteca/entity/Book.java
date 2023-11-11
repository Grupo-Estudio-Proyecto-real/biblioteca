package com.grupoJavaDiscord.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @Column(name = "cgender")       // Código de género del libro
    private Long cgender;

    @Column(name = "summary")       // Resumen breve del libro
    private String summary;

    @Column(name = "frontpage")     // Nombre de la imagen de la portada del libro en formato jpeg
    private String frontpage;

    @Column(name = "pathbook")      // Ruta y nombre del fichero del libro virtual.
    private String pathbook;

    @Column(name = "availability")  // Libro disponible: (D)isponible, (P)restado, (F)uera de servicio
    private String availability;
}
