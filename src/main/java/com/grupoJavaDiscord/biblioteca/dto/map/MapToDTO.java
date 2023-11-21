package com.grupoJavaDiscord.biblioteca.dto.map;

import com.grupoJavaDiscord.biblioteca.dto.BookDTO;
import com.grupoJavaDiscord.biblioteca.entity.Book;

public class MapToDTO {

    private MapToDTO() {
        throw new IllegalStateException("Utility class");
    }

    public static BookDTO mapBookToDTO (Book book) {

        return BookDTO.builder()
                .title(book.getTitle())
                .authors(book.getAuthors())
                .build();
    }
}
