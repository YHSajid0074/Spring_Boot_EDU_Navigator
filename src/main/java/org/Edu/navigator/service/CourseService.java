package org.Edu.navigator.service;

import org.Edu.navigator.dto.request.UserRequestDto;
import org.Edu.navigator.dto.response.UserResponseDto;
import org.Edu.navigator.model.course.Course;

import java.util.List;

public interface CourseService {

    UserResponseDto getCourseById(Long id);

    public List<UserResponseDto> getAllCourses();

    public UserResponseDto getCourseByName(String courseName);

    Course createCourse(UserRequestDto userRequestDto);

    public Course updateCourse(Long id, UserRequestDto userRequestDto);

    public void deleteCourse(Long id);

}
