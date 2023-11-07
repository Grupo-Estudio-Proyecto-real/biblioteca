package com.grupoJavaDiscord.biblioteca.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuser")
    private Long cuser;

    @Column(name = "name")
    private String name;

    @Column(name = "surnames")
    private String surnames;

    @Column(name = "dni", unique = true)
    private String dni;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "low")
    private String low;

    @Column(name = "dpenalty")
    private Integer dpenalty;


}
