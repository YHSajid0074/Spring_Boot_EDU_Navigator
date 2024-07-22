package org.Edu.navigator.Dto.RequestDto;

import org.Edu.navigator.entities.Coordinator;

import java.util.Set;

public record DirectorRequestDto(
        String fullName,
        String username,
        String email,
        Set<Coordinator> coordinators
) {
}
