package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.services.TrainerServices;
import org.Edu.navigator.entities.Trainer;
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
        return ResponseEntity.ok("Successfully Created");
    }

}
