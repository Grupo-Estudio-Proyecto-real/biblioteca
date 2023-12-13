package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.BookDTO;
import com.grupoJavaDiscord.biblioteca.dto.map.MapToDTO;
import com.grupoJavaDiscord.biblioteca.entity.Book;
import com.grupoJavaDiscord.biblioteca.exception.BookNotFoundException;
import com.grupoJavaDiscord.biblioteca.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    @Transactional(readOnly = true)
    public List<BookDTO> findAllBook() {

        List<Book> books = (List<Book>) bookRepository.findAll();

        return books.stream()
                .map(MapToDTO::mapBookToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BookDTO findBookById(Long cbook) {

        Optional<Book> existingBook = bookRepository.findById(cbook);
        System.out.println("Valor de existingBook:  " + existingBook.toString());
        return existingBook.map(MapToDTO::mapBookToDTO)
                .orElseThrow( () -> new BookNotFoundException(" Book not found because this id no exist"));
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {

        Book book = Book.builder()
                .title(bookDTO.getTitle())
                .authors(bookDTO.getAuthors())
                .isbn(bookDTO.getIsbn())
                .summary(bookDTO.getSummary())
                .issue(bookDTO.getIssue())
                .build();

        return MapToDTO.mapBookToDTO(bookRepository.save(book));
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO, Long cbook) {

        Optional<Book> existingBook = bookRepository.findById(cbook);

        Book book = existingBook.orElse(null);

        book.setTitle(bookDTO.getTitle());
        book.setAuthors(bookDTO.getAuthors());
        book.setIsbn(bookDTO.getIsbn());
        book.setSummary(bookDTO.getSummary());
        book.setIssue(bookDTO.getIssue());

        return MapToDTO.mapBookToDTO(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long cbook) {

        bookRepository.deleteById(cbook);
    }

}
