package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.dto.request.TrainerRequestDto;
import org.Edu.navigator.service.Impl.TrainerServiceImpl;
import org.Edu.navigator.model.Trainer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/Trainer")
public class TrainerController {


    private final TrainerServiceImpl trainerServiceImpl;


    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainer(@PathVariable Long id) {

        Trainer trainer = trainerServiceImpl.getTrainerById(id);

        return ResponseEntity.ok(trainer);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable Long id, @RequestBody TrainerRequestDto trainer) {

        Trainer updatedTrainer = trainerServiceImpl.updateTrainer(id, trainer);

        return ResponseEntity.ok(updatedTrainer);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable long id) {

        trainerServiceImpl.deleteTrainer(id);

        return ResponseEntity.ok("Deleted Trainer");
    }


    @PostMapping
    public ResponseEntity<Trainer> addTrainer(@RequestBody TrainerRequestDto trainerRequestDto) {

        Trainer createdTrainer = trainerServiceImpl.createTrainer(trainerRequestDto);

        return ResponseEntity.ok(createdTrainer);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Trainer>> getAllTrainers() {

        List<Trainer> trainers = trainerServiceImpl.getAllTrainers();

        return ResponseEntity.ok(trainers);

    }
}
