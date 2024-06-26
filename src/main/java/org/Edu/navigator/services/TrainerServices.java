package org.Edu.navigator.services;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Dto.TrainerDto;
import org.Edu.navigator.Exception.DuplicateEmailException;
import org.Edu.navigator.entities.Trainer;
import org.Edu.navigator.repositories.TrainerRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerServices {

 TrainerRepositories trainerRepositories;

 public TrainerServices(TrainerRepositories trainerRepositories) {
     this.trainerRepositories = trainerRepositories;
 }


 public List<Trainer> getAllTrainers() {
     return trainerRepositories.findAll();
 }


 public Trainer getTrainer(long id) {
     return trainerRepositories.getOne(id);
 }


 public Trainer createTrainer(TrainerDto trainerDto) {
     Trainer email=trainerRepositories.findByEmail(trainerDto.email());

     if(email!=null){
         throw new DuplicateEmailException("Email already exists");
     }

     Trainer trainer = new Trainer();
     trainer.setCoordinator(trainerDto.coordinator());
     trainer.setUsername(trainerDto.username());
     trainer.setEmail(trainerDto.email());
     trainer.setTrainees(trainerDto.trainees());
     trainer.setFullName(trainerDto.fullName());
     return trainerRepositories.save(trainer);
 }


 public Trainer updateTrainer(long id, TrainerDto trainerDto) {

     Trainer email=trainerRepositories.findByEmail(trainerDto.email());

     if(email!=null){
       throw new DuplicateEmailException("Email already exists");
     }

     Trainer trainer = trainerRepositories.getOne(id);
     trainer.setCoordinator(trainerDto.coordinator());
     trainer.setUsername(trainerDto.username());
     trainer.setEmail(trainerDto.email());
     trainer.setTrainees(trainerDto.trainees());
     trainer.setFullName(trainerDto.fullName());
     return trainerRepositories.save(trainer);
 }


 public void deleteTrainer(long id) {
     trainerRepositories.deleteById(id);
 }


}
