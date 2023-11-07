package com.grupoJavaDiscord.biblioteca.controller;

import org.springframework.data.repository.CrudRepository;
import com.grupoJavaDiscord.biblioteca.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserController extends CrudRepository <User, Long> {
}
