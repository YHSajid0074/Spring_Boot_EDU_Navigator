package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.dto.request.TraineeRequestDto;
import org.Edu.navigator.service.Impl.TraineeServiceImpl;
import org.Edu.navigator.model.Trainee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("trainee")
public class TraineeController {

    TraineeServiceImpl traineeServiceImpl;


    public TraineeController(TraineeServiceImpl traineeServiceImpl) {

        this.traineeServiceImpl = traineeServiceImpl;

    }


    @PostMapping
    public ResponseEntity<String> createTrainee(@RequestBody TraineeRequestDto traineeRequestDto) {

        traineeServiceImpl.createTrainee(traineeRequestDto);

        return ResponseEntity.ok("Trainee created");
    }


    @PutMapping
    public ResponseEntity<String> updateTrainee(@PathVariable Long id, @RequestBody TraineeRequestDto traineeRequestDto) {

        traineeServiceImpl.updateTrainee(id, traineeRequestDto);

        return ResponseEntity.ok("Trainee updated");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTrainee(@PathVariable Long id) {

        traineeServiceImpl.deleteTrainee(id);

        return ResponseEntity.ok("Trainee deleted");

    }


    @GetMapping("{id}")
    public ResponseEntity<Trainee> getTraineeById(@PathVariable Long id) {

        Trainee trainee = traineeServiceImpl.getTraineeById(id);

        return ResponseEntity.ok(trainee);

    }


    @GetMapping
    public ResponseEntity<List<Trainee>> getAllTrainee() {

        return ResponseEntity.ok(traineeServiceImpl.getAllTrainees());

    }


}
