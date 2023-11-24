package com.grupoJavaDiscord.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.*;

@ControllerAdvice
public class GlobalControlAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> bookNotFoundHandler(Exception e) {

        ApiError apiError = ApiError.builder()
                .message(e.getMessage())
                .description("Book not found")
                .date(java.time.LocalDate.now())
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IssueNotFoundException.class)
    public ResponseEntity<Object> issueNotFoundHandler(Exception e) {

        ApiError apiError = ApiError.builder()
                .message(e.getMessage())
                .description("Issue not found")
                .date(java.time.LocalDate.now())
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> userNotFounHandler(Exception e) {

        ApiError apiError = ApiError.builder()
                .message(e.getMessage())
                .description("User not found")
                .date(java.time.LocalDate.now())
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
