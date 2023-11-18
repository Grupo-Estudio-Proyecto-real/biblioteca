package com.grupoJavaDiscord.biblioteca.controller;

import com.grupoJavaDiscord.biblioteca.entity.Book;
import com.grupoJavaDiscord.biblioteca.service.BookService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAllBook() {

        return bookService.findAllBook();
    }

    @GetMapping("/{cbook}")
    @ResponseStatus(HttpStatus.OK)
    public Book findBookById(@PathVariable Long cbook) {

        return bookService.findBookById(cbook);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book) {

        return bookService.saveBook(book);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@RequestBody Book book) {

        return bookService.updateBook(book);
    }

    @DeleteMapping("/{cbook}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteBook(@PathVariable Long cbook) {

        bookService.deleteBook(cbook);
    }

}
