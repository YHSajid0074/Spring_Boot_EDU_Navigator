package org.Edu.navigator.service;

import org.Edu.navigator.dto.request.TraineeRequestDto;
import org.Edu.navigator.dto.response.TraineeResponseDto;
import org.Edu.navigator.model.trainee.Trainee;

import java.util.List;

public interface TraineeService {

    public TraineeResponseDto getTraineeById(Long id);

    public List<TraineeResponseDto> getAllTrainees();

    public Trainee createTrainee(TraineeRequestDto traineeRequestDto);

    public Trainee updateTrainee(Long id,TraineeRequestDto traineeRequestDto);

    public void deleteTrainee(Long id);

}
