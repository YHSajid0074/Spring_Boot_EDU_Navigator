package org.Edu.navigator.service.Impl;

import org.Edu.navigator.dto.request.CoordinatorRequestDto;
import org.Edu.navigator.common.exception.DuplicateEmailException;
import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.model.coordinator.Coordinator;
import org.Edu.navigator.repository.coordinator.CoordinatorRepositories;
import org.Edu.navigator.service.CoordinatorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinatorServiceImpl implements CoordinatorService {


    CoordinatorRepositories coordinatorRepositories;


    public CoordinatorServiceImpl(CoordinatorRepositories coordinatorRepositories) {

        this.coordinatorRepositories = coordinatorRepositories;

    }


    @Override
    public Coordinator createCoordinator(CoordinatorRequestDto coordinatorRequestDto) {

        Optional <Coordinator> email = coordinatorRepositories.findByEmail(coordinatorRequestDto.email());

        if (email == null) {
            throw new DuplicateEmailException("Email Already Exists");
        }

        Coordinator coordinator = new Coordinator();

        coordinator.setFullName(coordinatorRequestDto.fullName());
        coordinator.setEmail(coordinatorRequestDto.email());
        coordinator.setUsername(coordinatorRequestDto.username());
        coordinator.setDirector(coordinatorRequestDto.director());
        coordinator.setTrainers(coordinatorRequestDto.trainers());

        return coordinator;

    }


    @Override
    public CoordinatorResponseDto getCoordinator(Long id) {

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

        Optional <Coordinator> email = coordinatorRepositories.findByEmail(coordinatorRequestDto.email());

        if (email == null) {
            throw new DuplicateEmailException("Email Already Exists");
        }

        Coordinator coordinator = coordinatorRepositories.findById(id).get();

        coordinator.setEmail(coordinatorRequestDto.email());
        coordinator.setFullName(coordinatorRequestDto.fullName());
        coordinator.setUsername(coordinatorRequestDto.username());
        coordinator.setDirector(coordinatorRequestDto.director());
        coordinator.setTrainers(coordinatorRequestDto.trainers());

        return coordinator;

    }


    @Override
    public void deleteCoordinator(Long id) {

        coordinatorRepositories.deleteById(id);

    }

}
