package org.Edu.navigator.repository.director;

import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.dto.response.DirectorResponseDto;
import org.Edu.navigator.model.director.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DirectorRepositories extends JpaRepository<Director, Long> {

public Director findByEmail(String email);

    @Query("""
          SELECT d
            FROM Director d
              """
    )
    List<DirectorResponseDto> getAllDirector();


    @Query("""
            SELECT d
               FROM Director d
                  WHERE d.id=:id
                  """
    )
    public DirectorResponseDto findDirectorById(@Param("id") Long id);

}
