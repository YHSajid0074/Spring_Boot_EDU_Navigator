package org.Edu.navigator.dto.request;

import org.Edu.navigator.model.coordinator.Coordinator;
import org.Edu.navigator.model.trainee.Trainee;

import java.util.Set;

public record TrainerRequestDto(

        String fullName,
        String username,
        String email,
        Long coordinatorId,
        Set<Long> trainees

) {
}
