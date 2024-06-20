package org.Edu.navigator.services;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.entities.Trainer;
import org.Edu.navigator.repositories.TrainerRepositories;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainerServices {
  private final  TrainerRepositories trainerRepositories;
  public Trainer create(Trainer trainer){
      return trainerRepositories.save(trainer);
  }

}
