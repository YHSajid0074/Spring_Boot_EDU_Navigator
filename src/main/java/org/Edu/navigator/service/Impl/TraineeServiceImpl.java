package org.Edu.navigator.service.Impl;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.dto.request.TraineeRequestDto;
import org.Edu.navigator.exception.DuplicateEmailException;
import org.Edu.navigator.model.Trainee;
import org.Edu.navigator.repository.TraineeRepositories;
import org.Edu.navigator.service.TraineeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService {

    TraineeRepositories traineeRepositories;


    public TraineeServiceImpl(TraineeRepositories traineeRepositories) {

        this.traineeRepositories = traineeRepositories;

    }


    @Override
    public List<Trainee> getAllTrainees() {

        return traineeRepositories.findAll();

    }


    @Override
    public Trainee getTraineeById(Long id) {

        return traineeRepositories.findById(id).get();

    }

    @Override
    public Trainee createTrainee(TraineeRequestDto traineeRequestDto) {

        Trainee email = traineeRepositories.findByEmail(traineeRequestDto.email());

        if (email == null) {
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

    @Override
    public Trainee updateTrainee(Long id, TraineeRequestDto traineeRequestDto) {

        Trainee email = traineeRepositories.findByEmail(traineeRequestDto.email());

        if (email == null) {
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

    @Override
    public void deleteTrainee(Long id) {

        traineeRepositories.deleteById(id);

    }

}


