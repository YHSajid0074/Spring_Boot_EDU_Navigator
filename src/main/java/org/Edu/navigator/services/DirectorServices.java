package org.Edu.navigator.services;

import org.Edu.navigator.Dto.RequestDto.DirectorRequestDto;
import org.Edu.navigator.entities.Director;
import org.Edu.navigator.repositories.DirectorRepositories;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

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

    public Director createDirector(DirectorRequestDto directorRequestDto) {

        Director email = directorRepositories.findByEmail(directorRequestDto.email());
     if (email != null) {
         throw new DuplicateKeyException("Email already exists");
     }

        Director director = new Director();
        director.setCoordinators(directorRequestDto.coordinators());
        director.setEmail(directorRequestDto.email());
        director.setUsername(directorRequestDto.username());
        director.setFullName(directorRequestDto.fullName());
        return directorRepositories.save(director);
    }

    public Director updateDirector(Long id, DirectorRequestDto directorRequestDto) {

        Director email = directorRepositories.findByEmail(directorRequestDto.email());
        if (email == null) {
            throw new DuplicateKeyException("Email already exist");
        }

        Director director = directorRepositories.getById(id);
        director.setCoordinators(directorRequestDto.coordinators());
        director.setEmail(directorRequestDto.email());
        director.setUsername(directorRequestDto.username());
        director.setFullName(directorRequestDto.fullName());
        return directorRepositories.save(director);

    }

    public void deleteDirector(long id) {
        directorRepositories.deleteById(id);
    }

}
