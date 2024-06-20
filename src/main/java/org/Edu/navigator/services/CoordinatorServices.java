package org.Edu.navigator.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.Edu.navigator.entities.Coordinator;
import org.Edu.navigator.repositories.CoordinatorRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatorServices {
    @Autowired
    CoordinatorRepositories coordinatorRepositories;
    public Coordinator create(Coordinator coordinator) {
        return coordinatorRepositories.save(coordinator);
    }

    public Coordinator get(long id) {
        Coordinator coordinator = coordinatorRepositories.findById(id).get();
        return coordinator;
    }

    public List<Coordinator >GetAll(){
        List<Coordinator> coordinators = coordinatorRepositories.findAll();
        return coordinators;
    }

public void delete(long id) {
        coordinatorRepositories.deleteById(id);
}
}
