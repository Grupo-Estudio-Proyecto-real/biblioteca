package com.grupoJavaDiscord.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;
import com.grupoJavaDiscord.biblioteca.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
