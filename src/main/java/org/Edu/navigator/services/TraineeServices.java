package org.Edu.navigator.services;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Dto.RequestDto.TraineeRequestDto;
import org.Edu.navigator.Exception.DuplicateEmailException;
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


public Trainee createTrainee(TraineeRequestDto traineeRequestDto) {

    Trainee email=traineeRepositories.findByEmail(traineeRequestDto.email());

    if(email==null){
        throw new DuplicateEmailException("Email already exists");
    }

    Trainee trainee = new Trainee();
   trainee.setEmail(traineeRequestDto.email());
   trainee.setUsername(traineeRequestDto.username());
   trainee.setFullName(traineeRequestDto.fullName());
   trainee.setTrainer(traineeRequestDto.trainer());
   trainee.setCourses(traineeRequestDto.courses());
   return traineeRepositories.save(trainee);
}


public Trainee updateTrainee(long id, TraineeRequestDto traineeRequestDto) {

    Trainee email=traineeRepositories.findByEmail(traineeRequestDto.email());

    if(email==null){
        throw new DuplicateEmailException("Email already exists");
    }

    Trainee trainee = traineeRepositories.findById(id).get();
    trainee.setFullName(traineeRequestDto.fullName());
    trainee.setCourses(traineeRequestDto.courses());
    trainee.setTrainer(traineeRequestDto.trainer());
    trainee.setEmail(traineeRequestDto.email());
    trainee.setUsername(traineeRequestDto.username());
    return traineeRepositories.save(trainee);
}


public void deleteTrainee(long id) {
    traineeRepositories.deleteById(id);
}

}


