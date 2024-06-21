package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.services.TraineeServices;
import org.Edu.navigator.services.TrainerServices;
import org.Edu.navigator.entities.Trainer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Trainer")
public class TrianerController {
   TrainerServices trainerServices;
   public TrianerController(TrainerServices trainerServices) {
       this.trainerServices = trainerServices;
   }
   @GetMapping
   public ResponseEntity addTrainer(@PathVariable long id) {
      Trainer trainer= trainerServices.getTrainer(id);
       return ResponseEntity.ok(trainer);
   }

   



}
