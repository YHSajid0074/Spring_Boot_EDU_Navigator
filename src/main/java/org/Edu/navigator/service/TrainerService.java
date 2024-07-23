package org.Edu.navigator.service;

import org.Edu.navigator.dto.request.TrainerRequestDto;
import org.Edu.navigator.model.Trainer;

import java.util.List;

public interface TrainerService {

    public Trainer createTrainer(TrainerRequestDto trainerRequestDto);

    public Trainer updateTrainer(Long id,TrainerRequestDto trainerRequestDto);

    public void deleteTrainer(Long id);

    public List<Trainer> getAllTrainers();

    public Trainer getTrainerById(Long id);

    public Trainer getTrainerByName(String name);

}
