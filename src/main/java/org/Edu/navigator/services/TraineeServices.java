package org.Edu.navigator.services;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Dto.TraineeDto;
import org.Edu.navigator.entities.Trainee;
import org.Edu.navigator.repositories.TraineeRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraineeServices {

TraineeRepositories traineeRepositories;

public TraineeServices(TraineeRepositories traineeRepositories) {
    this.traineeRepositories = traineeRepositories;
}

public List<Trainee> getAllTrainees() {
    return traineeRepositories.findAll();
}

public Trainee getTraineeById(long id) {
    return traineeRepositories.findById(id).get();
}

public Trainee createTrainee(TraineeDto traineeDto) {
    Trainee trainee = new Trainee();
   trainee.setEmail(traineeDto.email());
   trainee.setUsername(traineeDto.username());
   trainee.setFullName(traineeDto.fullName());
   trainee.setTrainer(traineeDto.trainer());
   trainee.setCourses(traineeDto.courses());
   return traineeRepositories.save(trainee);
}

public Trainee updateTrainee(long id, TraineeDto traineeDto) {
    Trainee trainee = traineeRepositories.findById(id).get();
    trainee.setFullName(traineeDto.fullName());
    trainee.setCourses(traineeDto.courses());
    trainee.setTrainer(traineeDto.trainer());
    trainee.setEmail(traineeDto.email());
    trainee.setUsername(traineeDto.username());
    return traineeRepositories.save(trainee);
}

public void deleteTrainee(long id) {
    traineeRepositories.deleteById(id);
}

}


