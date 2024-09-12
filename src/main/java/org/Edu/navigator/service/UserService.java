package org.Edu.navigator.service;

import org.Edu.navigator.dto.request.UserRequestDto;
import org.Edu.navigator.dto.response.UserResponseDto;
import org.Edu.navigator.model.course.User;

import java.util.List;

public interface UserService {

    UserResponseDto getCourseById(Long id);

    public List<UserResponseDto> getAllCourses();

    public UserResponseDto getCourseByName(String courseName);

    User createCourse(UserRequestDto userRequestDto);

    public User updateCourse(Long id, UserRequestDto userRequestDto);

    public void deleteCourse(Long id);

}
