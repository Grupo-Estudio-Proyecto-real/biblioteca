package com.grupoJavaDiscord.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssueAdminDTO {

    @NotBlank(message = "Issue is required")
    @NotNull(message = "Issue cannot be null")
    @Size(min = 1, max = 20)
    private String issue;

    @NotBlank(message = "Subtopic is required")
    @NotNull(message = "Subtopic cannot be null")
    @Size(min = 1, max = 20)
    private String subtopic;
}
