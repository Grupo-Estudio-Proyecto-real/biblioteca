package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.entity.Book;
import com.grupoJavaDiscord.biblioteca.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Book> findAllBook() {

        return (List<Book>) bookRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Book findBookById(Long cbook) {

        return bookRepository.findById(cbook).orElse(null);
    }

    @Override
    public Book saveBook(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long cbook) {

        bookRepository.deleteById(cbook);
    }

}
