package org.Edu.navigator.service.Impl;

import org.Edu.navigator.dto.request.DirectorRequestDto;
import org.Edu.navigator.dto.response.DirectorResponseDto;
import org.Edu.navigator.model.director.Director;
import org.Edu.navigator.repository.director.DirectorRepositories;
import org.Edu.navigator.service.DirectorService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DirectorServiceImpl implements DirectorService {

    DirectorRepositories directorRepositories;


    public DirectorServiceImpl(DirectorRepositories directorRepositories) {

        this.directorRepositories = directorRepositories;

    }


    public Director convertToEntity(Director director, DirectorRequestDto directorRequestDto) {

        director.setCoordinators(directorRequestDto.coordinators());
        director.setEmail(directorRequestDto.email());
        director.setUsername(directorRequestDto.username());
        director.setFullName(directorRequestDto.fullName());

        return director;
    }


    @Override
    public List<DirectorResponseDto> getAllDirectors() {

        return directorRepositories.getAllDirector();

    }


    @Override
    public DirectorResponseDto getDirectorById(Long id) {

        return directorRepositories.findDirectorById(id);

    }


    @Override
    public Director createDirector(DirectorRequestDto directorRequestDto) {

        Director email = directorRepositories.findByEmail(directorRequestDto.email());
        if (email != null) {
            throw new DuplicateKeyException("Email already exists");
        }

        Director savedDirector = convertToEntity(new Director(), directorRequestDto);

        return directorRepositories.save(savedDirector);
    }


    @Override
    public Director updateDirector(Long id, DirectorRequestDto directorRequestDto) {

        Director email = directorRepositories.findByEmail(directorRequestDto.email());
        if (email == null) {
            throw new DuplicateKeyException("Email already exist");
        }

        Director directorUpdate = convertToEntity(directorRepositories.getById(id), directorRequestDto);

        return directorRepositories.save(directorUpdate);

    }


    
    @Override
    public void deleteDirector(Long id) {

        directorRepositories.deleteById(id);

    }

}
