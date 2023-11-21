package com.grupoJavaDiscord.biblioteca.exception;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {

    private String message;
    private String description;
    private LocalDate date;
}
