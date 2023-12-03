package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.BookAdminDTO;

import java.util.List;

public interface BookAdminService {

    List<BookAdminDTO> findAllBook();
    BookAdminDTO findBookById(Long cbook);
    BookAdminDTO saveBook(BookAdminDTO bookAdminDTO);
    BookAdminDTO updateBook(BookAdminDTO bookAdminDTO, Long cbook);
    void deleteBook(Long cbook);
}
