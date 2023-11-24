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
public class IssueDTO  implements Serializable {

    @NotBlank(message = "Issue is required")
    @NotNull(message = "Issue cannot be null")
    private String issue;

    @NotBlank(message = "Subtopic is required")
    @NotNull(message = "Subtopic cannot be null")
    private String subtopic;
}
