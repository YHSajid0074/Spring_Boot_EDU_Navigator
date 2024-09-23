package org.Edu.navigator.repository.course;

import org.Edu.navigator.dto.response.CourseResponseDto;
import org.Edu.navigator.model.course.Course;
import org.Edu.navigator.model.trainee.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CourseRepo extends JpaRepository<Course, Long> {

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

    Set<Course> getCourseByIdIsIn(Set<Long> ids);


}
