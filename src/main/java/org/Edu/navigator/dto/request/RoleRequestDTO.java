package org.Edu.navigator.dto.request;


import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record RoleRequestDTO(
        Long id,
        @NotNull String roleType

)
        implements Serializable {
}