package com.grupoJavaDiscord.biblioteca.controller;

import com.grupoJavaDiscord.biblioteca.dto.BookDTO;
import com.grupoJavaDiscord.biblioteca.entity.Book;
import com.grupoJavaDiscord.biblioteca.exception.BookNotFoundException;
import com.grupoJavaDiscord.biblioteca.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> findAllBook() {

        List<BookDTO> bookDTOS = bookService.findAllBook();

        if (bookDTOS.isEmpty()) {
            throw new BookNotFoundException("No books found, the list is empty.")
        }
        return bookDTOS;
    }

    @GetMapping("/{cbook}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO findBookById(@PathVariable Long cbook) {

        return bookService.findBookById(cbook);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO saveBook(@RequestBody @Valid BookDTO bookDTO) {

        return bookService.saveBook(book);
    }

    @PutMapping("/{cbook}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@RequestBody @Valid BookDTO bookDTO, @PathVariable Long cbook) {

        return bookService.updateBook(book, cbook);
    }

    @DeleteMapping("/{cbook}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteBook(@PathVariable Long cbook) {

        bookService.deleteBook(cbook);
    }

}
