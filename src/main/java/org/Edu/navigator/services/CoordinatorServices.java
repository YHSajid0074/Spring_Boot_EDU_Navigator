package org.Edu.navigator.services;

import lombok.NoArgsConstructor;
import org.Edu.navigator.Dto.RequestDto.CoordinatorRequestDto;
import org.Edu.navigator.Exception.DuplicateEmailException;
import org.Edu.navigator.entities.Coordinator;
import org.Edu.navigator.repositories.CoordinatorRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@NoArgsConstructor
public class CoordinatorServices {

    CoordinatorRepositories coordinatorRepositories;

    public CoordinatorServices (CoordinatorRepositories coordinatorRepositories) {
        this.coordinatorRepositories=coordinatorRepositories;
    }

    public Coordinator create(CoordinatorRequestDto coordinatorRequestDto) {

        Coordinator email=coordinatorRepositories.findByEmail(coordinatorRequestDto.email());

        if(email==null){
            throw  new DuplicateEmailException("Email Already Exists");
        }

        Coordinator coordinator = new Coordinator();
        coordinator.setFullName(coordinatorRequestDto.fullName());
        coordinator.setEmail(coordinatorRequestDto.email());
        coordinator.setUsername(coordinatorRequestDto.username());
        coordinator.setDirector(coordinatorRequestDto.director());
        coordinator.setTrainers(coordinatorRequestDto.trainers());
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

    public Coordinator update(long id, CoordinatorRequestDto coordinatorRequestDto) {

        Coordinator email=coordinatorRepositories.findByEmail(coordinatorRequestDto.email());
        if(email==null){
            throw  new DuplicateEmailException("Email Already Exists");
        }

        Coordinator coordinator=coordinatorRepositories.findById(id).get();
        coordinator.setEmail(coordinatorRequestDto.email());
        coordinator.setFullName(coordinatorRequestDto.fullName());
        coordinator.setUsername(coordinatorRequestDto.username());
        coordinator.setDirector(coordinatorRequestDto.director());
        coordinator.setTrainers(coordinatorRequestDto.trainers());
        return coordinator;
    }

      public void delete(long id) {
          coordinatorRepositories.deleteById(id);
}
}
