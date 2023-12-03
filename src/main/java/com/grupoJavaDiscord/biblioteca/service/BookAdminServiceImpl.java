package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.BookAdminDTO;
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
public class BookAdminServiceImpl implements BookAdminService {


    private final BookRepository bookRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BookAdminDTO> findAllBook() {

        List<Book> books = (List<Book>) bookRepository.findAll();

        return books.stream()
            .map(MapToDTO::mapBookAdminToDTO)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BookAdminDTO findBookById(Long cbook) {

        Optional<Book> existingBook = bookRepository.findById(cbook);

        return existingBook.map(MapToDTO::mapBookAdminToDTO)
                .orElseThrow( () -> new BookNotFoundException("(Service) - Book not found because this id no exist"));
    }

    @Override
    public BookAdminDTO saveBook(BookAdminDTO bookAdminDTO) {

        Book book = Book.builder()
                .title(bookAdminDTO.getTitle())
                .authors(bookAdminDTO.getAuthors())
                .summary(bookAdminDTO.getSummary())
                .isbn(bookAdminDTO.getIsbn())
                .frontpage(bookAdminDTO.getFrontpage())
                .pathbook(bookAdminDTO.getPathbook())
                .availability(bookAdminDTO.getAvailability())
                .build();

        return MapToDTO.mapBookAdminToDTO(bookRepository.save(book));
    }

    @Override
    public BookAdminDTO updateBook(BookAdminDTO bookAdminDTO, Long cbook) {

        Optional<Book> existingBook = bookRepository.findById(cbook);

        Book book = existingBook.orElse(null);

        book.setTitle(bookAdminDTO.getTitle());
        book.setAuthors(bookAdminDTO.getAuthors());
        book.setSummary(bookAdminDTO.getSummary());
        book.setDedition(bookAdminDTO.getDedition());
        book.setFrontpage(bookAdminDTO.getFrontpage());
        book.setPathbook(bookAdminDTO.getPathbook());
        book.setAvailability(bookAdminDTO.getAvailability());

        return MapToDTO.mapBookAdminToDTO(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long cbook) {

        Optional<Book> existingBook = bookRepository.findById(cbook);

        Book book = existingBook.orElseThrow( () -> new BookNotFoundException("(Servoce) - Book not found because this id no exist"));

        bookRepository.deleteById(cbook);

    }
}
