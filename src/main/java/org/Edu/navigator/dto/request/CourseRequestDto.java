package org.Edu.navigator.dto.request;

import org.Edu.navigator.model.Trainee;

import java.util.Set;

public record CourseRequestDto(

      Long id,
      String name,
      Integer duration,
      Set<Trainee> trainee

) {
}
