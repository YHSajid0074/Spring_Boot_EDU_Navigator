package org.Edu.navigator.Dto.RequestDto;

import org.Edu.navigator.entities.Trainee;

import java.util.Set;

public record CourseRequestDto(
      Long id,
      String name,
      Integer duration,
      Set<Trainee> trainee
) {
}
