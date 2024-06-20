package org.noob.learnspringdatajpa.controller;

import lombok.RequiredArgsConstructor;
import org.noob.learnspringdatajpa.entities.Director;
import org.noob.learnspringdatajpa.entities.Trainer;
import org.noob.learnspringdatajpa.services.DirectorServices;
import org.noob.learnspringdatajpa.services.TraineeServices;
import org.noob.learnspringdatajpa.services.TrainerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("Trainer")
public class TrianerController {
    private final TrainerServices trainerServices;
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Trainer trainer){
        trainerServices.create(trainer);
        return ResponseEntity.ok("Successfully Created you big noob");
    }

}
