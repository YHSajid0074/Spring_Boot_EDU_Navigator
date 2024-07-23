package org.Edu.navigator.dto.request;

import org.Edu.navigator.model.Course;
import org.Edu.navigator.model.Trainer;

import java.util.Set;

public record TraineeRequestDto(

        String fullName,
        String username,
        String email,
        Trainer trainer,
        Set<Course> courses

) {
}
