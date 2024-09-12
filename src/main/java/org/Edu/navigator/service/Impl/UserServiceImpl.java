package org.Edu.navigator.service.Impl;

import org.Edu.navigator.dto.request.UserRequestDto;
import org.Edu.navigator.dto.response.UserResponseDto;
import org.Edu.navigator.model.course.User;
import org.Edu.navigator.repository.course.CourseRepositories;
import org.Edu.navigator.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final CourseRepositories courseRepositories;


    public UserServiceImpl(CourseRepositories courseRepositories) {

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
    public User createCourse(UserRequestDto userRequestDto) {

        User user = new User();

        user.setDuration(userRequestDto.duration());
        user.setName(userRequestDto.name());
        user.setTrainee(userRequestDto.trainee());

        return courseRepositories.save(user);
    }


    @Override
    public User updateCourse(Long id, UserRequestDto userRequestDto) {

     User user =courseRepositories.findById(id).get();

     user.setName(userRequestDto.name());
     user.setTrainee(userRequestDto.trainee());
     user.setDuration(userRequestDto.duration());

     return courseRepositories.save(user);
    }


    @Override
    public void deleteCourse(Long id) {

        courseRepositories.deleteById(id);

    }

}
