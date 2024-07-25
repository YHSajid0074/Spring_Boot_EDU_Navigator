package org.Edu.navigator.repository.trainee;

import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.dto.response.TraineeResponseDto;
import org.Edu.navigator.model.trainee.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TraineeRepositories extends JpaRepository<Trainee, Long> {

    public Trainee findByEmail(String name);


    @Query("""
            SELECT t
              FROM Trainee t
                """
    )
    List<TraineeResponseDto> getAllTrainee();

    @Query("""
            SELECT t
               FROM Trainee t
                  WHERE t.id=:id
                  """
    )
    public TraineeResponseDto findTraineeById(@Param("id") Long id);

}
