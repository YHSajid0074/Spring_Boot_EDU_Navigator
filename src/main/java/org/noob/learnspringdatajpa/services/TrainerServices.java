package org.noob.learnspringdatajpa.services;

import lombok.RequiredArgsConstructor;
import org.noob.learnspringdatajpa.entities.Trainer;
import org.noob.learnspringdatajpa.repositories.TrainerRepositories;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainerServices {
  private final  TrainerRepositories trainerRepositories;
  public Trainer create(Trainer trainer){
      return trainerRepositories.save(trainer);
  }

}
