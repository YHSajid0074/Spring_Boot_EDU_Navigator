package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.services.TraineeServices;
import org.Edu.navigator.entities.Trainee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("trainee")
public class TraineeController {
    private final TraineeServices traineeServices;
    @PostMapping("post")
    public ResponseEntity<String> create(@RequestBody Trainee trainee){
        traineeServices.create(trainee);
        return ResponseEntity.ok("Successfully Created");
    }
}
