package org.Edu.navigator.service.Impl;

import org.Edu.navigator.dto.request.TraineeRequestDto;
import org.Edu.navigator.common.exception.DuplicateEmailException;
import org.Edu.navigator.dto.response.TraineeResponseDto;
import org.Edu.navigator.model.trainee.Trainee;
import org.Edu.navigator.model.trainer.Trainer;
import org.Edu.navigator.repository.course.CourseRepo;
import org.Edu.navigator.repository.trainee.TraineeRepositories;
import org.Edu.navigator.repository.trainer.TrainerRepositories;
import org.Edu.navigator.service.TraineeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService {

    TraineeRepositories traineeRepositories;
    TrainerRepositories trainerRepositories;
    CourseRepo courseRepo;


    public TraineeServiceImpl(TraineeRepositories traineeRepositories, TrainerRepositories trainerRepositories, CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
        this.traineeRepositories = traineeRepositories;
        this.trainerRepositories = trainerRepositories;

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
        Trainer trainer = trainerRepositories.getTrainerById(traineeRequestDto.trainerId());

        Trainee email = traineeRepositories.findByEmail(traineeRequestDto.email());

        if (email == null) {
            throw new DuplicateEmailException("Email already exists");
        }

        Trainee trainee = new Trainee();

        trainee.setEmail(traineeRequestDto.email());
        trainee.setUsername(traineeRequestDto.username());
        trainee.setFullName(traineeRequestDto.fullName());
        trainee.setTrainer(trainer);
        trainee.setCourse(courseRepo.getCourseByIdIsIn(traineeRequestDto.course()));

        return traineeRepositories.save(trainee);

    }

    @Override
    public Trainee updateTrainee(Long id, TraineeRequestDto traineeRequestDto) {
        Trainer trainer = trainerRepositories.getTrainerById(traineeRequestDto.trainerId());
        Trainee email = traineeRepositories.findByEmail(traineeRequestDto.email());

        if (email == null) {
            throw new DuplicateEmailException("Email already exists");
        }

        Trainee trainee = traineeRepositories.findById(id).get();

        trainee.setFullName(traineeRequestDto.fullName());
        trainee.setCourse(courseRepo.getCourseByIdIsIn(traineeRequestDto.course()));
        trainee.setTrainer(trainer);
        trainee.setEmail(traineeRequestDto.email());
        trainee.setUsername(traineeRequestDto.username());

        return traineeRepositories.save(trainee);
    }

    @Override
    public void deleteTrainee(Long id) {

        traineeRepositories.deleteById(id);

    }

}


