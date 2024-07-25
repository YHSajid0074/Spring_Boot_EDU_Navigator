package org.Edu.navigator.service;

import org.Edu.navigator.dto.request.TrainerRequestDto;
import org.Edu.navigator.dto.response.TrainerResponseDto;
import org.Edu.navigator.model.trainer.Trainer;

import java.util.List;

public interface TrainerService {

    public Trainer createTrainer(TrainerRequestDto trainerRequestDto);

    public Trainer updateTrainer(Long id,TrainerRequestDto trainerRequestDto);

    public void deleteTrainer(Long id);

    public List<TrainerResponseDto> getAllTrainers();

    public TrainerResponseDto getTrainerById(Long id);

    public TrainerResponseDto getTrainerByName(String name);

}
