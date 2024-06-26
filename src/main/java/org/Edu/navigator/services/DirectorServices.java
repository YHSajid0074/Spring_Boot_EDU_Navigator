package org.Edu.navigator.services;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Dto.DirectorDto;
import org.Edu.navigator.entities.Director;
import org.Edu.navigator.repositories.DirectorRepositories;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service

public class DirectorServices {

    DirectorRepositories directorRepositories;

    public DirectorServices(DirectorRepositories directorRepositories) {
        this.directorRepositories = directorRepositories;
    }

    public List<Director> getAllDirectors() {
       return directorRepositories.findAll();
    }

    public Director getDirectorById(long id) {
        return directorRepositories.getById(id);
    }

    public Director createDirector(DirectorDto directorDto) {

        Director email = directorRepositories.findByEmail(directorDto.email());
     if (email != null) {
         throw new DuplicateKeyException("Email already exists");
     }

        Director director = new Director();
        director.setCoordinators(directorDto.coordinators());
        director.setEmail(directorDto.email());
        director.setUsername(directorDto.username());
        director.setFullName(directorDto.fullName());
        return directorRepositories.save(director);
    }

    public Director updateDirector(Long id,DirectorDto directorDto) {

        Director email = directorRepositories.findByEmail(directorDto.email());
        if (email == null) {
            throw new DuplicateKeyException("Email already exist");
        }

        Director director = directorRepositories.getById(id);
        director.setCoordinators(directorDto.coordinators());
        director.setEmail(directorDto.email());
        director.setUsername(directorDto.username());
        director.setFullName(directorDto.fullName());
        return directorRepositories.save(director);

    }

    public void deleteDirector(long id) {
        directorRepositories.deleteById(id);
    }

}
