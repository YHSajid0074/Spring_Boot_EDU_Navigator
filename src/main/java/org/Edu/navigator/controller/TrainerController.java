package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Dto.RequestDto.TrainerRequestDto;
import org.Edu.navigator.services.TrainerServices;
import org.Edu.navigator.entities.Trainer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/Trainer")
public class TrainerController {

    private final TrainerServices trainerServices;

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainer(@PathVariable long id) {
        Trainer trainer = trainerServices.getTrainer(id);
        return ResponseEntity.ok(trainer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable long id, @RequestBody TrainerRequestDto trainer) {
        Trainer updatedTrainer = trainerServices.updateTrainer(id, trainer);
        return ResponseEntity.ok(updatedTrainer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable long id) {
        trainerServices.deleteTrainer(id);
        return ResponseEntity.ok("Deleted Trainer");
    }

    @PostMapping
    public ResponseEntity<Trainer> addTrainer(@RequestBody TrainerRequestDto trainerRequestDto) {
        Trainer createdTrainer = trainerServices.createTrainer(trainerRequestDto);
        return ResponseEntity.ok(createdTrainer);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        List<Trainer> trainers = trainerServices.getAllTrainers();
        return ResponseEntity.ok(trainers);
    }
}
