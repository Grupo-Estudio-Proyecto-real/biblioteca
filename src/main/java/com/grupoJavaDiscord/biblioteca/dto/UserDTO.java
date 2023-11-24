package com.grupoJavaDiscord.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO  implements Serializable {

    @NotBlank(message = "Name of User is required")
    @NotNull(message = "Name of User cannot be null")
    private String name;

    @NotBlank(message = "Surname of User is required")
    @NotNull(message = "Surname of User cannot be null")
    private String surnames;

    @NotBlank(message = "Address of User is required")
    @NotNull(message = "Address of User cannot be null")
    private String address;

    @NotBlank(message = "Phone of User is required")
    @NotNull(message = "Phone of User cannot be null")
    private String phone;

    @NotBlank(message = "E-Mail of User is required")
    @NotNull(message = "E-Mail of User cannot be null")
    private String email;

}
