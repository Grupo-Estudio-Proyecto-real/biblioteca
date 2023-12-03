package com.grupoJavaDiscord.biblioteca.controller;

import com.grupoJavaDiscord.biblioteca.dto.BookAdminDTO;
import com.grupoJavaDiscord.biblioteca.exception.BookNotFoundException;
import com.grupoJavaDiscord.biblioteca.exception.BookNotSaveException;
import com.grupoJavaDiscord.biblioteca.service.BookAdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/library")
@RequiredArgsConstructor
public class BookAdminController {

    private final BookAdminService bookAdminService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<BookAdminDTO> findAllBook() {

        List<BookAdminDTO> bookDTOS = bookAdminService.findAllBook();

        if (bookDTOS.isEmpty()) {
            throw new BookNotFoundException("(Controller) - No books found, the list is empty.");
        }
        return bookDTOS;
    }

    @GetMapping("/{cbook}")
    @ResponseStatus(HttpStatus.OK)
    public BookAdminDTO findBookById(@PathVariable Long cbook) {

        Optional<BookAdminDTO> book = Optional.ofNullable(bookAdminService.findBookById(cbook));

        if (book.isPresent()) {
            return  book.get();
        } else {
            throw new BookNotFoundException("(Controller) - Book with id is not found " + cbook);
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookAdminDTO saveBook(@RequestBody @Valid BookAdminDTO bookAdminDTO) {

        try {
            return bookAdminService.saveBook(bookAdminDTO);
        } catch (BookNotSaveException e) {
            throw new BookNotSaveException("(Controller) - Book can´t create correctly");
        }
    }

    @PutMapping("/{cbook}")
    @ResponseStatus(HttpStatus.OK)
    public BookAdminDTO updateBook(@RequestBody @Valid BookAdminDTO bookAdminDTO, @PathVariable Long cbook) {

        Optional<BookAdminDTO> existingBook = Optional.ofNullable(bookAdminService.findBookById(cbook));

        try {
            if(existingBook.isEmpty()) {
                throw new BookNotFoundException("(Controller) - Book with id is not found " + cbook);
            }

            return bookAdminService.updateBook(bookAdminDTO, cbook);
        } catch (BookNotFoundException e) {
            throw new BookNotSaveException("(Controller) - Book can´t update correctly");
        }
    }

    @DeleteMapping("/{cbook}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteBook(@PathVariable Long cbook) {

        Optional<BookAdminDTO> existingBook = Optional.ofNullable(bookAdminService.findBookById(cbook));

        if (existingBook.isEmpty()) {
            throw new BookNotFoundException("(Controller) - Book with id is not found " + cbook);
        }

        bookAdminService.deleteBook(cbook);
    }
}
