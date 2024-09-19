package org.Edu.navigator.service.Impl;

import org.Edu.navigator.dto.request.UserRequestDto;
import org.Edu.navigator.dto.response.UserResponseDto;
import org.Edu.navigator.model.course.Course;
import org.Edu.navigator.repository.course.CourseRepo;
import org.Edu.navigator.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepositories;


    public CourseServiceImpl(CourseRepo courseRepositories) {

        this.courseRepositories = courseRepositories;

    }


    @Override
    public UserResponseDto getCourseById(Long id) {

      UserResponseDto userResponseDto =  courseRepositories.findCourseById(id);

      return userResponseDto;
    }


    @Override
    public List<UserResponseDto> getAllCourses() {

        return courseRepositories.getAllCourse();

    }


    @Override
    public UserResponseDto getCourseByName(String courseName) {
        return null;
    }


    @Override
    public Course createCourse(UserRequestDto userRequestDto) {

        Course course = new Course();

        course.setDuration(userRequestDto.duration());
        course.setName(userRequestDto.name());
        course.setTrainee(userRequestDto.trainee());

        return courseRepositories.save(course);
    }


    @Override
    public Course updateCourse(Long id, UserRequestDto userRequestDto) {

     Course course =courseRepositories.findById(id).get();

     course.setName(userRequestDto.name());
     course.setTrainee(userRequestDto.trainee());
     course.setDuration(userRequestDto.duration());

     return courseRepositories.save(course);
    }


    @Override
    public void deleteCourse(Long id) {

        courseRepositories.deleteById(id);

    }

}
