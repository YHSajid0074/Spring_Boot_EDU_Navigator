package org.Edu.navigator.repositories;

import org.Edu.navigator.Dto.CourseDto;
import org.Edu.navigator.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositories extends JpaRepository<Course, Long> {

}
