package com.grupoJavaDiscord.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class LoanNotSaveException extends RuntimeException {
    public LoanNotSaveException(String message) { super(message); }
}
