package org.Edu.navigator.Dto;

import org.Edu.navigator.entities.Trainee;

import java.util.Set;

public record CourseDto(
      Long id,
      String name,
      Integer duration,
      Set<Trainee> trainee
) {
}
