package com.grupoJavaDiscord.biblioteca.dto;

import com.grupoJavaDiscord.biblioteca.entity.Availability;
import com.grupoJavaDiscord.biblioteca.entity.Issue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookAdminDTO implements Serializable {

    @NotBlank(message = "Title is required")
    @NotNull(message = "Title cannot be null")
    @Size(min = 1, max = 80)
    private String title;

    @NotBlank(message = "ISBN is required")
    @NotNull(message = "ISBN cannot be null")
    @Size(min = 1, max = 17)
    private String isbn;

    @NotBlank(message = "Authors is required")
    @NotNull(message = "Authors cannot be null")
    @Size(min = 1, max = 80)
    private String authors;

    @NotBlank(message = "Summary is required")
    @NotNull(message = "Summary cannot be null")
    @Size(min = 1, max = 255)
    private String summary;

    @NotBlank(message = "Date edition is required")
    @NotNull(message = "Date edition cannot be null")
    @Size(min = 1, max = 10)
    private String dedition;

    @NotBlank(message = "Frontpage is required")
    @NotNull(message = "Frontpage cannot be null")
    @Size(min = 1, max = 60)
    private String frontpage;

    @NotBlank(message = "Pathbook is required")
    @NotNull(message = "Pathbook cannot be null")
    @Size(min = 1, max = 200)
    private String pathbook;

    @NotBlank(message = "Availability is required")
    @NotNull(message = "Availabolity cannot be null")
    private Availability availability;

    private Issue issue;
}
