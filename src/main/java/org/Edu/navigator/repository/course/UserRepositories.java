package org.Edu.navigator.repository.user;

import org.Edu.navigator.dto.response.UserResponseDto;
import org.Edu.navigator.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepositories extends JpaRepository<User, Long> {

    @Query("""
          SELECT c
            FROM User c
          """
    )
    List<UserResponseDto> getAllCourse();


    @Query("""
            SELECT c 
               FROM User c 
                  WHERE c.id=:id
                  """
    )
    public UserResponseDto findCourseById(@Param("id") Long id);


}
