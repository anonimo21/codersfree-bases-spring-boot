package com.codersfree.prueba.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @NotBlank(message = "El nombre es requerido")
    @Size(min = 3, max = 10, message = "El nombre debe tener entre 3 y 10 caracteres")
    private String name;

    @NotBlank(message = "El email es requerido")
    @Size(min = 3, max = 10, message = "El email debe tener entre 3 y 10 caracteres")
    @Email(message = "El email debe ser valido")
    private String email;
}
