package org.Edu.navigator.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UserRolesRequestDTO(
        @NotNull( message = "User id can't be null or empty." )
        Long userId,

        @NotNull( message = "Role ids can't be null or empty." )
        Set< Long > roleIds
) {
}