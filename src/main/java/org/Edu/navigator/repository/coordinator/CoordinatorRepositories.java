package org.Edu.navigator.repository.coordinator;

import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.model.coordinator.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CoordinatorRepositories extends JpaRepository<Coordinator, Long> {

    @Query("""
          SELECT coordinator 
            FROM Coordinator coordinator
              """
            )
    Set<CoordinatorResponseDto> getAll();

    public Coordinator findByEmail(String email);

}
