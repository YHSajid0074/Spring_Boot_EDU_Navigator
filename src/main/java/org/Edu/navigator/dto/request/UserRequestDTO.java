package org.Edu.navigator.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

/**

 */

public record UserRequestDTO(
        Long id,

        @NotEmpty( message = "Username can't be null or empty." )
        String username,

        @NotEmpty( message = "Email address can't be null or empty." )
        @Email( message = "Enter a valid email address." )
        String email,

        @NotEmpty( message = "Password can't be null or empty." )
        String password
) implements Serializable {
}