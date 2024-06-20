package org.Edu.navigator.repositories;

import org.Edu.navigator.Dto.CoordinatorDto;
import org.Edu.navigator.Dto.CustomCoordinatorResponseDto;
import org.Edu.navigator.entities.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CoordinatorRepositories extends JpaRepository<Coordinator, Long> {
    @Query("""
          SELECT coordinator 
            FROM Coordinator coordinator
              """
            )
    Set<CustomCoordinatorResponseDto> findall();

}
