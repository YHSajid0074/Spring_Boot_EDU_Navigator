package org.Edu.navigator.service.Impl;

import org.Edu.navigator.dto.request.TrainerRequestDto;
import org.Edu.navigator.common.exception.DuplicateEmailException;
import org.Edu.navigator.dto.response.TrainerResponseDto;
import org.Edu.navigator.model.coordinator.Coordinator;
import org.Edu.navigator.model.trainer.Trainer;
import org.Edu.navigator.repository.coordinator.CoordinatorRepositories;
import org.Edu.navigator.repository.trainee.TraineeRepositories;
import org.Edu.navigator.repository.trainer.TrainerRepositories;
import org.Edu.navigator.service.TrainerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService {

    private final CoordinatorRepositories coordinatorRepositories;
    TrainerRepositories trainerRepositories;
    TraineeRepositories traineeRepositories;

    public TrainerServiceImpl(TrainerRepositories trainerRepositories, CoordinatorRepositories coordinatorRepositories,TraineeRepositories traineeRepositories) {
        this.trainerRepositories = trainerRepositories;
        this.coordinatorRepositories = coordinatorRepositories;
        this.traineeRepositories = traineeRepositories;
    }

    @Override
    public List<TrainerResponseDto> getAllTrainers() {

        return trainerRepositories.getAllTrainer();

    }

    @Override
    public TrainerResponseDto getTrainerById(Long id) {

        return trainerRepositories.findTrainerById(id);

    }

    @Override
    public TrainerResponseDto getTrainerByName(String name) {
        return null;
    }

    @Override
    public Trainer createTrainer(TrainerRequestDto trainerRequestDto) {

        Optional<Coordinator> coordinator = coordinatorRepositories.findById(trainerRequestDto.coordinatorId());

        Trainer email = trainerRepositories.findByEmail(trainerRequestDto.email());

        if (email != null) {
            throw new DuplicateEmailException("Email already exists");
        }

        Trainer trainer = new Trainer();

        trainer.setCoordinator(coordinator.get());
        trainer.setUsername(trainerRequestDto.username());
        trainer.setEmail(trainerRequestDto.email());
        trainer.setTrainees(traineeRepositories.getTraineeByIdIsIn(trainerRequestDto.trainees()));
        trainer.setFullName(trainerRequestDto.fullName());

        return trainerRepositories.save(trainer);
    }


    @Override
    public Trainer updateTrainer(Long id, TrainerRequestDto trainerRequestDto) {
        Optional<Coordinator> coordinator = coordinatorRepositories.findById(trainerRequestDto.coordinatorId());

        Trainer email = trainerRepositories.findByEmail(trainerRequestDto.email());

        if (email != null) {
            throw new DuplicateEmailException("Email already exists");
        }

        Trainer trainer = trainerRepositories.getOne(id);

        trainer.setCoordinator(coordinator.get());
        trainer.setUsername(trainerRequestDto.username());
        trainer.setEmail(trainerRequestDto.email());
        trainer.setTrainees(traineeRepositories.getTraineeByIdIsIn(trainerRequestDto.trainees()));
        trainer.setFullName(trainerRequestDto.fullName());

        return trainerRepositories.save(trainer);
    }


    @Override
    public void deleteTrainer(Long id) {

        trainerRepositories.deleteById(id);

    }


}
