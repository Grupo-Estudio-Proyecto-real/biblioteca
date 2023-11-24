package com.grupoJavaDiscord.biblioteca.dto.map;

import com.grupoJavaDiscord.biblioteca.dto.BookDTO;
import com.grupoJavaDiscord.biblioteca.dto.IssueDTO;
import com.grupoJavaDiscord.biblioteca.dto.UserDTO;
import com.grupoJavaDiscord.biblioteca.entity.Book;
import com.grupoJavaDiscord.biblioteca.entity.Issue;
import com.grupoJavaDiscord.biblioteca.entity.User;

public class MapToDTO {

    private MapToDTO() {
        throw new IllegalStateException("Utility class");
    }

    public static BookDTO mapBookToDTO (Book book) {

        return BookDTO.builder()
                .title(book.getTitle())
                .authors(book.getAuthors())
                .summary((book.getSummary()))
                .build();
    }

    public static IssueDTO mapIssueToDTO (Issue issue) {

        return IssueDTO.builder()
                .issue(issue.getIssue())
                .subtopic(issue.getSubtopic())
                .build();
    }

    public static UserDTO mapUserToDTO (User user) {

        return UserDTO.builder()
                .name(user.getName())
                .surnames(user.getSurnames())
                .address(user.getAddress())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }
}
