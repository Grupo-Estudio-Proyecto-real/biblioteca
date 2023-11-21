package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.BookDTO;
import com.grupoJavaDiscord.biblioteca.entity.Book;
import java.util.List;

public interface BookService {

    List<BookDTO> findAllBook();
    BookDTO findBookById(Long cbook);
    BookDTO saveBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO, Long cbook);
    void deleteBook(Long cbook);
}
