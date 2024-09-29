package org.Edu.navigator.auth.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;


public record LoginRequestDTO(
        @NotEmpty( message = "Username is mandatory." )
        @NotBlank( message = "Username is mandatory." )
        String username,
        @NotEmpty( message = "Password is mandatory." )
        @NotBlank( message = "Password is mandatory." )
        String password
) implements Serializable {
}