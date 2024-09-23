package org.Edu.navigator.repository.director;

import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.dto.response.DirectorResponseDto;
import org.Edu.navigator.model.director.Director;
import org.Edu.navigator.model.trainer.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

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

    @Query("""
            SELECT d
               FROM Director d
                  WHERE d.id=:id
                  """
    )
    public Director getDirectorById(@Param("id") Long id);

    Set<Director> getDirectorByIdIsIn(Set<Long> ids);

}
