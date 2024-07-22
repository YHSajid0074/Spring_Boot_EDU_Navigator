package org.Edu.navigator.services;

import org.Edu.navigator.Dto.RequestDto.CourseRequestDto;
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

    public Course createCourse(CourseRequestDto courseRequestDto) {
        Course course = new Course();
        course.setDuration(courseRequestDto.duration());
        course.setName(courseRequestDto.name());
        course.setTrainee(courseRequestDto.trainee());
        return courseRepositories.save(course);
    }

    public Course updateCourse(long id, CourseRequestDto courseRequestDto) {
     Course course=courseRepositories.findById(id).get();
     course.setName(courseRequestDto.name());
     course.setTrainee(courseRequestDto.trainee());
     course.setDuration(courseRequestDto.duration());
     return courseRepositories.save(course);
    }

    public void deleteCourse(long id) {
        courseRepositories.deleteById(id);
    }

}
