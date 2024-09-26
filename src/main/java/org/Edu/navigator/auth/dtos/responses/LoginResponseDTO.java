package org.Edu.navigator.auth.dtos.responses;

import java.io.Serializable;
import java.util.Set;



public record LoginResponseDTO(
        String token,
        String username,
        String email,
        Set< String > roles
) implements Serializable {
}