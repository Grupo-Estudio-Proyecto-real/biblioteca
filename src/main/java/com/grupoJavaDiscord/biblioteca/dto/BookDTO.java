package com.grupoJavaDiscord.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO implements Serializable {

    @NotBlank(message = "Title is required")
    @NotNull(message = "Title cannot be null")
    private String title;

    @NotBlank(message = "Authors is required")
    @NotNull(message = "Authors cannot be null")
    private String authors;

    @NotBlank(message = "Summary is required")
    @NotNull(message = "Summary cannot be null")
    private String summary;

}
