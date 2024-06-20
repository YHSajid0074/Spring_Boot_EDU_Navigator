package org.Edu.navigator.Dto;

import org.Edu.navigator.entities.Coordinator;
import org.Edu.navigator.entities.Trainee;

import java.util.Set;

public record TrainerDto(
        String fullName,
        String username,
        String email,
        Coordinator coordinator,
        Set<Trainee> trainees
) {
}
