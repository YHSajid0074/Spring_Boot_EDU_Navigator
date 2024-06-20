package org.Edu.navigator.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.Edu.navigator.Dto.CoordinatorDto;
import org.Edu.navigator.entities.Coordinator;
import org.Edu.navigator.repositories.CoordinatorRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@NoArgsConstructor
public class CoordinatorServices {

    CoordinatorRepositories coordinatorRepositories;
    public CoordinatorServices (CoordinatorRepositories coordinatorRepositories) {
        this.coordinatorRepositories=coordinatorRepositories;
    }
    public Coordinator create(CoordinatorDto coordinatorDto) {
        Coordinator coordinator = new Coordinator();
        coordinator.setFullName(coordinatorDto.fullName());
        coordinator.setEmail(coordinatorDto.email());
        coordinator.setUsername(coordinatorDto.username());
        coordinator.setDirector(coordinatorDto.director());
        coordinator.setTrainers(coordinatorDto.trainers());
        return coordinator;
    }

    public Coordinator get(long id) {
       Coordinator coordinator=coordinatorRepositories.findById(id).get();
       return coordinator;
    }

    public List<Coordinator >GetAll(){
        List<Coordinator> coordinators = coordinatorRepositories.findAll();
        return coordinators;
    }
    public Coordinator update(long id, CoordinatorDto coordinatorDto) {
        Coordinator coordinator=coordinatorRepositories.findById(id).get();
        coordinator.setEmail(coordinatorDto.email());
        coordinator.setFullName(coordinatorDto.fullName());
        coordinator.setUsername(coordinatorDto.username());
        coordinator.setDirector(coordinatorDto.director());
        coordinator.setTrainers(coordinatorDto.trainers());
        return coordinator;
    }
public void delete(long id) {
        coordinatorRepositories.deleteById(id);
}
}
