package org.Edu.navigator.dto.request;

import org.Edu.navigator.model.Coordinator;

import java.util.Set;

public record DirectorRequestDto(

        String fullName,
        String username,
        String email,
        Set<Coordinator> coordinators

) {
}
