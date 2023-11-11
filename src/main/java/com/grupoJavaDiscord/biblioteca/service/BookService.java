package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.entity.Book;
import java.util.List;

public interface BookService {

    List<Book> findAllBook();
    Book findBookById(Long cbook);
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long cbook);
}
