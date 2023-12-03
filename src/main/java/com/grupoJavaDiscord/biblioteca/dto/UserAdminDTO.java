package com.grupoJavaDiscord.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAdminDTO {
    @NotBlank(message = "Name of User is required")
    @NotNull(message = "Name of User cannot be null")
    @Size(min = 1, max = 30)
    private String name;

    @NotBlank(message = "Surname of User is required")
    @NotNull(message = "Surname of User cannot be null")
    @Size(min = 1, max = 50)
    private String surnames;

    @NotBlank(message = "Address of User is required")
    @NotNull(message = "Address of User cannot be null")
    @Size(min = 1, max = 100)
    private String address;

    @NotBlank(message = "Phone of User is required")
    @NotNull(message = "Phone of User cannot be null")
    @Size(min = 1, max = 17)
    private String phone;

    @NotBlank(message = "E-Mail of User is required")
    @NotNull(message = "E-Mail of User cannot be null")
    @Size(min = 1, max = 30)
    private String email;

    @NotBlank(message = "DNI of User is required")
    @NotNull(message = "DNI of User cannot be null")
    @Size(min = 1, max = 10)
    private String dni;

    @NotBlank(message = "Password of User is required")
    @NotNull(message = "Password of User cannot be null")
    @Size(min = 1, max = 25)
    private String password;

    private Integer dpenalty;

    private String low;

}
