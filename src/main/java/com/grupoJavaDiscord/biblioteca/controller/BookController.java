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
import java.util.Optional;

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
            throw new BookNotFoundException("No books found, the list is empty.");
        }
        return bookDTOS;
    }

    @GetMapping("/{cbook}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO findBookById(@PathVariable Long cbook) {

        Optional<BookDTO> book = Optional.ofNullable(bookService.findBookById(cbook));

        if (book.isPresent()) {
            return  book.get();
        } else {
            throw new BookNotFoundException("Book with id is not found " + cbook);
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO saveBook(@RequestBody @Valid BookDTO bookDTO) {

        try {
            return bookService.saveBook(bookDTO);
        } catch (BookNotFoundException e) {
            throw new BookNotFoundException("Book can´t create correctly");
        }

    }

    @PutMapping("/{cbook}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO updateBook(@RequestBody @Valid BookDTO bookDTO, @PathVariable Long cbook) {

        Optional<BookDTO> existingbook = Optional.ofNullable(bookService.findBookById(cbook));

        try {

            if (existingbook.isEmpty()) {
                throw new BookNotFoundException("Book with id is not found " + cbook);
            }
            return bookService.updateBook(bookDTO, cbook);

        } catch (BookNotFoundException e) {
            throw new BookNotFoundException("Book can´t update correctly");
        }


    }

    @DeleteMapping("/{cbook}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteBook(@PathVariable Long cbook) {

        Optional<BookDTO> existingbook = Optional.ofNullable(bookService.findBookById(cbook));

        if (existingbook.isEmpty()) {
            throw new BookNotFoundException("Book with id is not found " + cbook);
        }

        bookService.deleteBook(cbook);
    }

}
