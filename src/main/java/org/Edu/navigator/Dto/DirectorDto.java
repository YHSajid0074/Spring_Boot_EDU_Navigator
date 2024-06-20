package org.Edu.navigator.Dto;

import org.Edu.navigator.entities.Coordinator;

import java.util.Set;

public record DirectorDto(
        Set<Coordinator> coordinators
) {
}
