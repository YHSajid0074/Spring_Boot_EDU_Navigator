package org.Edu.navigator.service;

import org.Edu.navigator.dto.request.TraineeRequestDto;
import org.Edu.navigator.model.Trainee;

import java.util.List;

public interface TraineeService {

    public Trainee getTraineeById(Long id);

    public List<Trainee> getAllTrainees();

    public Trainee createTrainee(TraineeRequestDto traineeRequestDto);

    public Trainee updateTrainee(Long id,TraineeRequestDto traineeRequestDto);

    public void deleteTrainee(Long id);

}
