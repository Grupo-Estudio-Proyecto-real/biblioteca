package com.grupoJavaDiscord.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;
import com.grupoJavaDiscord.biblioteca.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
