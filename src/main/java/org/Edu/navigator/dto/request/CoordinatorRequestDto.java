package org.Edu.navigator.dto.request;

import org.Edu.navigator.model.director.Director;
import org.Edu.navigator.model.trainer.Trainer;

import java.util.Set;

public record CoordinatorRequestDto(

        String fullName,
        String username,
        String email,
        Director director,
        Set<Trainer> trainers

) {
}
