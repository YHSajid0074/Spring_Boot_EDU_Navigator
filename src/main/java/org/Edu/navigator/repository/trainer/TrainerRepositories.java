package org.Edu.navigator.repository.trainer;

import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.dto.response.TrainerResponseDto;
import org.Edu.navigator.model.trainer.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface TrainerRepositories extends JpaRepository<Trainer, Long> {

     Trainer findByEmail(String name);


     @Query("""
          SELECT t
            FROM Trainer t
          """
     )
     List<TrainerResponseDto> getAllTrainer();


     @Query("""
            SELECT t
               FROM Trainer t
                  WHERE t.id=:id
                  """
     )
      TrainerResponseDto findTrainerById(@Param("id") Long id);


     @Query("""
            SELECT t
               FROM Trainer t
                  WHERE t.id=:id
                  """
     )
      Trainer getTrainerById(@Param("id") Long id);


     Set<Trainer> getTrainerByIdIsIn(Set<Long> ids);

}
