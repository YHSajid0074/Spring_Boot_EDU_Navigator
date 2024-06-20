package org.noob.learnspringdatajpa.services;

import lombok.RequiredArgsConstructor;
import org.noob.learnspringdatajpa.entities.Trainee;
import org.noob.learnspringdatajpa.repositories.TraineeRepositories;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TraineeServices {
    private final TraineeRepositories traineeRepositories;
    public Trainee create(Trainee trainee){
      return  traineeRepositories.save(trainee);

    }

}
