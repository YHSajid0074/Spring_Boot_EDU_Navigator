package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Dto.TraineeDto;
import org.Edu.navigator.services.TraineeServices;
import org.Edu.navigator.entities.Trainee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("trainee")
public class TraineeController {

    TraineeServices traineeServices;


    public TraineeController(TraineeServices traineeServices) {
        this.traineeServices = traineeServices;
    }

     @PostMapping
    public ResponseEntity<String> createTrainee(@RequestBody TraineeDto traineeDto){
        traineeServices.createTrainee(traineeDto);
        return ResponseEntity.ok("Trainee created");
    }


     @PutMapping
    public ResponseEntity<String> updateTrainee(@PathVariable long id ,@RequestBody TraineeDto traineeDto){
        traineeServices.updateTrainee(id,traineeDto);
        return ResponseEntity.ok("Trainee updated");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTrainee(@PathVariable long id){
        traineeServices.deleteTrainee(id);
        return ResponseEntity.ok("Trainee deleted");
    }

    @GetMapping("{id}")
    public ResponseEntity<Trainee> getTraineeById(@PathVariable long id){
      Trainee trainee=traineeServices.getTraineeById(id);
      return ResponseEntity.ok(trainee);
    }
    @GetMapping
    public ResponseEntity<List<Trainee>> getAllTrainee(){
      return ResponseEntity.ok(traineeServices.getAllTrainees());
    }




}
