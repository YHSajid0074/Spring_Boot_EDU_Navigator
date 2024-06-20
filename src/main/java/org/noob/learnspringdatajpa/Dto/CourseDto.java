package org.noob.learnspringdatajpa.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import org.noob.learnspringdatajpa.entities.Trainee;

import java.util.Set;

public record CourseDto(
      Long id,
      String name,
      Integer duration,
      Set<Trainee> trainee
) {
}
