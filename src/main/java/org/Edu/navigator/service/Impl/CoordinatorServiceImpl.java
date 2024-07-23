package org.Edu.navigator.service.Impl;

import lombok.NoArgsConstructor;
import org.Edu.navigator.dto.request.CoordinatorRequestDto;
import org.Edu.navigator.exception.DuplicateEmailException;
import org.Edu.navigator.model.Coordinator;
import org.Edu.navigator.repository.CoordinatorRepositories;
import org.Edu.navigator.service.CoordinatorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinatorServiceImpl implements CoordinatorService {


    CoordinatorRepositories coordinatorRepositories;


    public CoordinatorServiceImpl(CoordinatorRepositories coordinatorRepositories) {

        this.coordinatorRepositories = coordinatorRepositories;

    }


    @Override
    public Coordinator createCoordinator(CoordinatorRequestDto coordinatorRequestDto) {

        Coordinator email = coordinatorRepositories.findByEmail(coordinatorRequestDto.email());

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
    public Coordinator getCoordinator(Long id) {

        Coordinator coordinator = coordinatorRepositories.findById(id).get();

        return coordinator;

    }


    @Override
    public List<Coordinator> GetAllCoordinator() {

        List<Coordinator> coordinators = coordinatorRepositories.findAll();
        return coordinators;

    }


    @Override
    public Coordinator updateCoordinator(Long id, CoordinatorRequestDto coordinatorRequestDto) {

        Coordinator email = coordinatorRepositories.findByEmail(coordinatorRequestDto.email());
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
