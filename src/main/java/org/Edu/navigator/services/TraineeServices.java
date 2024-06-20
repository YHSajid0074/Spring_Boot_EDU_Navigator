package org.Edu.navigator.services;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.entities.Trainee;
import org.Edu.navigator.repositories.TraineeRepositories;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TraineeServices {
    private final TraineeRepositories traineeRepositories;
    public Trainee create(Trainee trainee){
      return  traineeRepositories.save(trainee);

    }

}
