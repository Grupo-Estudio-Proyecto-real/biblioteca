package com.grupoJavaDiscord.biblioteca.dto.map;

import com.grupoJavaDiscord.biblioteca.dto.*;
import com.grupoJavaDiscord.biblioteca.entity.Book;
import com.grupoJavaDiscord.biblioteca.entity.Issue;
import com.grupoJavaDiscord.biblioteca.entity.Loan;
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

    public static BookAdminDTO mapBookAdminToDTO (Book book) {

        return BookAdminDTO.builder()
                .title(book.getTitle())
                .authors(book.getAuthors())
                .summary(book.getSummary())
                .isbn(book.getIsbn())
                .dedition(book.getDedition())
                .frontpage(book.getFrontpage())
                .pathbook(book.getPathbook())
                .availability(book.getAvailability())
                .build();
    }

    public static IssueAdminDTO mapIssueAdminToDTO (Issue issue) {

        return IssueAdminDTO.builder()
                .issue(issue.getIssue())
                .subtopic(issue.getSubtopic())
                .build();
    }

    public static UserAdminDTO mapUserAdminToDTO (User user) {

        return UserAdminDTO.builder()
                .name(user.getName())
                .surnames(user.getSurnames())
                .address(user.getAddress())
                .dni(user.getDni())
                .phone(user.getPhone())
                .email(user.getEmail())
                .password(user.getPassword())
                .low(user.getLow())
                .dpenalty(user.getDpenalty())
                .build();
    }

    public static LoanAdminDTO mapLoanAdminToDTO (Loan loan) {

        return LoanAdminDTO.builder()
                .floan(loan.getFloan())
                .daysloan(loan.getDaysloan())
                .build();
    }

}
