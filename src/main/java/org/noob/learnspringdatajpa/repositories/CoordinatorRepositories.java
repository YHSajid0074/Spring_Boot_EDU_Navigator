package org.noob.learnspringdatajpa.repositories;

import org.noob.learnspringdatajpa.Dto.CustomCoordinatorResponseDto;
import org.noob.learnspringdatajpa.entities.Coordinator;
import org.noob.learnspringdatajpa.entities.Director;
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
