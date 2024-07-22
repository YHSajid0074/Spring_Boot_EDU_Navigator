package org.Edu.navigator.repositories;

import org.Edu.navigator.Dto.ResponseDto.CoordinatorResponseDto;
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
    Set<CoordinatorResponseDto> findall();

    public Coordinator findByEmail(String email);

}
