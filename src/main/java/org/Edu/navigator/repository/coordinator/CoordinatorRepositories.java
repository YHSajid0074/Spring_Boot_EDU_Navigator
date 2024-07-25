package org.Edu.navigator.repository.coordinator;

import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.model.coordinator.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CoordinatorRepositories extends JpaRepository<Coordinator, Long> {

    @Query("""
          SELECT c
            FROM Coordinator c
          """
            )
    List<CoordinatorResponseDto> getAllCoordinator();


    Optional <Coordinator> findByEmail(String email);


    @Query("""
            SELECT c
               FROM Coordinator c 
                  WHERE c.id=:id
                  """
    )
     CoordinatorResponseDto findCoordinatorById(@Param("id") Long id);

}
