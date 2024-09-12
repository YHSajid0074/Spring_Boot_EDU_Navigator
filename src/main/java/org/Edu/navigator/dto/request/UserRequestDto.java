package org.Edu.navigator.dto.request;

import org.Edu.navigator.model.trainee.Trainee;

import java.util.Set;

public record UserRequestDto(

      Long id,
      String name,
      Integer duration,
      Set<Trainee> trainee

) {
}
