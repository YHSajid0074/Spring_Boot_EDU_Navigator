package org.noob.learnspringdatajpa.services;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.noob.learnspringdatajpa.entities.Director;
import org.noob.learnspringdatajpa.repositories.DirectorRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("Director")
@Service
@RequiredArgsConstructor
public class DirectorServices {
    private final DirectorRepositories directorRepositories;
    public Director create(Director director) {
        return directorRepositories.save(director);
    }
    public Director getbyID(long id) {
        Director director=directorRepositories.findById(id).get();
        return  director;
    }

    public List<Director> getAll() {
       List< Director> director=directorRepositories.findAll();
       return director;
    }
    public void delete(long id) {
        directorRepositories.deleteById(id);
    }

}
