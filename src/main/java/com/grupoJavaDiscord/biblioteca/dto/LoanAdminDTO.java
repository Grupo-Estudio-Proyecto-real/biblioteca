package com.grupoJavaDiscord.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanAdminDTO {

    @NotBlank(message = "Title is required")
    @NotNull(message = "Title cannot be null")
    private String floan;

    @NotBlank(message = "Title is required")
    @NotNull(message = "Title cannot be null")
    private Integer daysloan;
}
