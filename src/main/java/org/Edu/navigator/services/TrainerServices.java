package org.Edu.navigator.services;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Dto.RequestDto.TrainerRequestDto;
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


 public Trainer createTrainer(TrainerRequestDto trainerRequestDto) {
     Trainer email=trainerRepositories.findByEmail(trainerRequestDto.email());

     if(email!=null){
         throw new DuplicateEmailException("Email already exists");
     }

     Trainer trainer = new Trainer();
     trainer.setCoordinator(trainerRequestDto.coordinator());
     trainer.setUsername(trainerRequestDto.username());
     trainer.setEmail(trainerRequestDto.email());
     trainer.setTrainees(trainerRequestDto.trainees());
     trainer.setFullName(trainerRequestDto.fullName());
     return trainerRepositories.save(trainer);
 }


 public Trainer updateTrainer(long id, TrainerRequestDto trainerRequestDto) {

     Trainer email=trainerRepositories.findByEmail(trainerRequestDto.email());

     if(email!=null){
       throw new DuplicateEmailException("Email already exists");
     }

     Trainer trainer = trainerRepositories.getOne(id);
     trainer.setCoordinator(trainerRequestDto.coordinator());
     trainer.setUsername(trainerRequestDto.username());
     trainer.setEmail(trainerRequestDto.email());
     trainer.setTrainees(trainerRequestDto.trainees());
     trainer.setFullName(trainerRequestDto.fullName());
     return trainerRepositories.save(trainer);
 }


 public void deleteTrainer(long id) {
     trainerRepositories.deleteById(id);
 }


}
