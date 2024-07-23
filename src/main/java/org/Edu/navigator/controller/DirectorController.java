package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.dto.request.DirectorRequestDto;
import org.Edu.navigator.model.Director;
import org.Edu.navigator.service.Impl.DirectorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("directors")
public class DirectorController {


    private final DirectorServiceImpl directorServiceImpl;


    @PostMapping("post")
    public ResponseEntity<Director> create(DirectorRequestDto directorRequestDto) {
        Director director1 = directorServiceImpl.createDirector(directorRequestDto);
        return ResponseEntity.ok(director1);

    }


    @GetMapping("{id}")
    public ResponseEntity<Director> getID(@PathVariable Long id) {
        Director director = directorServiceImpl.getDirectorById(id);
        return ResponseEntity.ok(director);

    }


    @GetMapping("GetAll")
    public ResponseEntity<List<Director>> getAll() {
        List<Director> directors = directorServiceImpl.getAllDirectors();
        return ResponseEntity.ok(directors);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        directorServiceImpl.deleteDirector(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
