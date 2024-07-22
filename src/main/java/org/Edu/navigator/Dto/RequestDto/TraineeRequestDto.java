package org.Edu.navigator.Dto.RequestDto;

import org.Edu.navigator.entities.Course;
import org.Edu.navigator.entities.Trainer;

import java.util.Set;

public record TraineeRequestDto(
        String fullName,
        String username,
        String email,
        Trainer trainer,
        Set<Course> courses
) {
}
