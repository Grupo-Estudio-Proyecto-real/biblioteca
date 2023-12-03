package com.grupoJavaDiscord.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users",
                catalog = "biblioteca",
                indexes = {@Index(name = "UK_DNI", columnList = "dni", unique = true)})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuser", length = 6)
    private Long cuser;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "surnames", nullable = false, length = 50)
    private String surnames;

    @Column(name = "dni", nullable = false, length = 10)
    private String dni;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "phone", length = 17)
    private String phone;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "password", length = 25)
    private String password;

    @Column(name = "low", length = 10)
    private String low;                     // Any value is user unregistered

    @Column(name = "dpenalty", length = 3)
    private Integer dpenalty;

    @OneToMany(mappedBy = "user")
    private List<Loan> loans;
}
