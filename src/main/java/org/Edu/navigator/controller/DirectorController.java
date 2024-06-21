package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Dto.DirectorDto;
import org.Edu.navigator.entities.Director;
import org.Edu.navigator.services.DirectorServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("directors")
public class DirectorController {


    private final DirectorServices directorServices;


    @PostMapping("post")
    public ResponseEntity<Director>create(DirectorDto directorDto) {
        Director director1= directorServices.createDirector(directorDto);
       return ResponseEntity.ok(director1);

    }


    @GetMapping("{id}")
    public ResponseEntity<Director>getID(@PathVariable Long id) {
        Director director=directorServices.getDirectorById(id);
        return ResponseEntity.ok(director);

    }


    @GetMapping("GetAll")
    public ResponseEntity<List<Director>>getAll() {
        List<Director>directors= directorServices.getAllDirectors();
        return ResponseEntity.ok(directors);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String>delete(@PathVariable long id) {
        directorServices.deleteDirector(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
