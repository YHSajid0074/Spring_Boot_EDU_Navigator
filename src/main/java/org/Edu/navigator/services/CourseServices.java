package org.Edu.navigator.services;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Dto.CourseDto;
import org.Edu.navigator.entities.Course;
import org.Edu.navigator.repositories.CourseRepositories;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServices {
    private final CourseRepositories courseRepositories;
    public CourseServices(CourseRepositories courseRepositories) {
        this.courseRepositories = courseRepositories;
    }
    public Course getCourseById(long id) {
      Course course=  courseRepositories.findById(id).get();
      return course;
    }

    public List<Course> getAllCourses() {
        return courseRepositories.findAll();
    }

    public Course createCourse(CourseDto courseDto) {
        Course course = new Course();
        

    }


}
