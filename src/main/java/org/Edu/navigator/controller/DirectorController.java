package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Director>create(Director director) {
        Director director1= directorServices.create(director);
       return ResponseEntity.ok(director1);

    }
    @GetMapping("{id}")
    public ResponseEntity<Director>getID(@PathVariable Long id) {
        Director director=directorServices.getbyID(id);
        return ResponseEntity.ok(director);

    }
    @GetMapping("GetAll")
    public ResponseEntity<List<Director>>getAll() {
        List<Director>directors= directorServices.getAll();
        return ResponseEntity.ok(directors);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>delete(@PathVariable long id) {
        directorServices.delete(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
