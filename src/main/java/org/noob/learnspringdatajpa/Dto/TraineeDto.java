package org.noob.learnspringdatajpa.Dto;

import org.noob.learnspringdatajpa.entities.Course;
import org.noob.learnspringdatajpa.entities.Trainer;

import java.util.Set;

public record TraineeDto(
        Trainer trainer,
        Set<Course> courses
) {
}
