package org.Edu.navigator.repository.course;

import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.dto.response.CourseResponseDto;
import org.Edu.navigator.model.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepositories extends JpaRepository<Course, Long> {

    @Query("""
          SELECT c
            FROM Course c
          """
    )
    List<CourseResponseDto> getAllCourse();


    @Query("""
            SELECT c 
               FROM Course c 
                  WHERE c.id=:id
                  """
    )
    public CourseResponseDto findCourseById(@Param("id") Long id);


}
