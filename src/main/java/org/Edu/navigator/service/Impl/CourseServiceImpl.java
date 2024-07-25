package org.Edu.navigator.service.Impl;

import org.Edu.navigator.dto.request.CourseRequestDto;
import org.Edu.navigator.dto.response.CourseResponseDto;
import org.Edu.navigator.model.course.Course;
import org.Edu.navigator.repository.course.CourseRepositories;
import org.Edu.navigator.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepositories courseRepositories;


    public CourseServiceImpl(CourseRepositories courseRepositories) {

        this.courseRepositories = courseRepositories;

    }


    @Override
    public CourseResponseDto getCourseById(Long id) {

      CourseResponseDto courseResponseDto=  courseRepositories.findCourseById(id);

      return courseResponseDto;
    }


    @Override
    public List<CourseResponseDto> getAllCourses() {

        return courseRepositories.getAllCourse();

    }


    @Override
    public CourseResponseDto getCourseByName(String courseName) {
        return null;
    }


    @Override
    public Course createCourse(CourseRequestDto courseRequestDto) {

        Course course = new Course();

        course.setDuration(courseRequestDto.duration());
        course.setName(courseRequestDto.name());
        course.setTrainee(courseRequestDto.trainee());

        return courseRepositories.save(course);
    }


    @Override
    public Course updateCourse(Long id, CourseRequestDto courseRequestDto) {

     Course course=courseRepositories.findById(id).get();

     course.setName(courseRequestDto.name());
     course.setTrainee(courseRequestDto.trainee());
     course.setDuration(courseRequestDto.duration());

     return courseRepositories.save(course);
    }


    @Override
    public void deleteCourse(Long id) {

        courseRepositories.deleteById(id);

    }

}
