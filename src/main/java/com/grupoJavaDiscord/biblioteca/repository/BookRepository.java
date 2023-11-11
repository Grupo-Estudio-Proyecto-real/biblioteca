package com.grupoJavaDiscord.biblioteca.repository;

import com.grupoJavaDiscord.biblioteca.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
