package org.Edu.navigator.repository.course;

import org.Edu.navigator.dto.response.UserResponseDto;
import org.Edu.navigator.model.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {

    @Query("""
          SELECT c
            FROM Course c
          """
    )
    List<UserResponseDto> getAllCourse();


    @Query("""
            SELECT c 
               FROM Course c 
                  WHERE c.id=:id
                  """
    )
    public UserResponseDto findCourseById(@Param("id") Long id);


}
