package org.Edu.navigator.service.Impl;

import org.Edu.navigator.dto.request.TraineeRequestDto;
import org.Edu.navigator.common.exception.DuplicateEmailException;
import org.Edu.navigator.dto.response.TraineeResponseDto;
import org.Edu.navigator.model.trainee.Trainee;
import org.Edu.navigator.repository.trainee.TraineeRepositories;
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
    public List<TraineeResponseDto> getAllTrainees() {

        return traineeRepositories.getAllTrainee();

    }


    @Override
    public TraineeResponseDto getTraineeById(Long id) {

        return traineeRepositories.findTraineeById(id);

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
        trainee.setCours(traineeRequestDto.cours());

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
        trainee.setCours(traineeRequestDto.cours());
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


