package org.Edu.navigator.service;

import org.Edu.navigator.dto.request.CourseRequestDto;
import org.Edu.navigator.dto.response.CourseResponseDto;
import org.Edu.navigator.model.course.Course;

import java.util.List;

public interface CourseService {

    CourseResponseDto getCourseById(Long id);

    public List<CourseResponseDto> getAllCourses();

    public CourseResponseDto getCourseByName(String courseName);

    Course createCourse(CourseRequestDto courseRequestDto);

    public Course updateCourse(Long id, CourseRequestDto courseRequestDto);

    public void deleteCourse(Long id);

}
