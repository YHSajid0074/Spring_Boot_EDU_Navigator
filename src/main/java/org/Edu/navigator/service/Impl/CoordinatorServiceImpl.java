package org.Edu.navigator.service.Impl;

import org.Edu.navigator.dto.request.CoordinatorRequestDto;
import org.Edu.navigator.common.exception.DuplicateEmailException;
import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.model.coordinator.Coordinator;
import org.Edu.navigator.model.director.Director;
import org.Edu.navigator.model.trainer.Trainer;
import org.Edu.navigator.repository.coordinator.CoordinatorRepositories;
import org.Edu.navigator.repository.director.DirectorRepositories;
import org.Edu.navigator.repository.trainer.TrainerRepositories;
import org.Edu.navigator.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CoordinatorServiceImpl implements CoordinatorService {


    CoordinatorRepositories coordinatorRepositories;
    DirectorRepositories directorRepositories;
    TrainerRepositories trainerRepositories;
    @Autowired

    public CoordinatorServiceImpl(CoordinatorRepositories coordinatorRepositories,DirectorRepositories directorRepositories,TrainerRepositories trainerRepositories) {
        this.trainerRepositories = trainerRepositories;
        this.coordinatorRepositories = coordinatorRepositories;
        this.directorRepositories = directorRepositories;
    }


    @Override
    public Coordinator createCoordinator(CoordinatorRequestDto coordinatorRequestDto) {
        Director director = directorRepositories.getDirectorById(coordinatorRequestDto.DirectorId());
        Optional <CoordinatorResponseDto> email = coordinatorRepositories.findByEmail(coordinatorRequestDto.email());

        if (email == null) {
            throw new DuplicateEmailException("Email Already Exists");
        }

        Coordinator coordinator = new Coordinator();

        coordinator.setFullName(coordinatorRequestDto.fullName());
        coordinator.setEmail(coordinatorRequestDto.email());
        coordinator.setUsername(coordinatorRequestDto.username());
        coordinator.setDirector(director);
        coordinator.setTrainers(trainerRepositories.getTrainerByIdIsIn(coordinatorRequestDto.trainersId()));

        return coordinator;

    }


    @Override
    public CoordinatorResponseDto getCoordinatorById(Long id) {

        CoordinatorResponseDto coordinatorResponseDto = coordinatorRepositories.findCoordinatorById(id);

        return coordinatorResponseDto;

    }


    @Override
    public List<CoordinatorResponseDto> GetAllCoordinator() {

        List<CoordinatorResponseDto> coordinators = coordinatorRepositories.getAllCoordinator();
        return coordinators;

    }


    @Override
    public Coordinator updateCoordinator(Long id, CoordinatorRequestDto coordinatorRequestDto) {
        Director director = directorRepositories.getDirectorById(coordinatorRequestDto.DirectorId());
        Optional <CoordinatorResponseDto> email = coordinatorRepositories.findByEmail(coordinatorRequestDto.email());

        if (email == null) {
            throw new DuplicateEmailException("Email Already Exists");
        }

        Coordinator coordinator = coordinatorRepositories.findById(id).get();

        coordinator.setEmail(coordinatorRequestDto.email());
        coordinator.setFullName(coordinatorRequestDto.fullName());
        coordinator.setUsername(coordinatorRequestDto.username());
        coordinator.setDirector(director);
        Set<Trainer> trainers = new HashSet<>();
        for (Long trainerId : coordinatorRequestDto.trainersId()) {
            Trainer trainer = trainerRepositories.getTrainerById(trainerId);
            if (trainer != null) {
                trainers.add(trainer);
            }
        }
        coordinator.setTrainers(trainers);

        return coordinator;

    }


    @Override
    public void deleteCoordinator(Long id) {

        coordinatorRepositories.deleteById(id);

    }

}
