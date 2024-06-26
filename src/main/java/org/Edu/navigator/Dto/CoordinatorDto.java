package org.Edu.navigator.Dto;

import org.Edu.navigator.entities.Director;
import org.Edu.navigator.entities.Trainer;

import java.util.Set;

public record CoordinatorDto(
        String fullName,
        String username,
        String email,
        Director director,
        Set<Trainer> trainers
) {
}
