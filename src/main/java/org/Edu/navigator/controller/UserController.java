package org.Edu.navigator.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.Edu.navigator.common.constant.Message;
import org.Edu.navigator.common.routes.ApiConstants;
import org.Edu.navigator.common.routes.Router;
import org.Edu.navigator.dto.request.UserRequestDto;
import org.Edu.navigator.dto.response.UserResponseDto;
import org.Edu.navigator.service.Impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path= Router.COURSE)
@Tag(name= ApiConstants.COURSE)
public class UserController {


    public final UserServiceImpl courseServiceImpl;


    @PostMapping(Router.CREATE_COURSE)
    public ResponseEntity<String> create(@RequestBody UserRequestDto userRequestDto) {

        courseServiceImpl.createCourse(userRequestDto);

        return ResponseEntity.ok(Message.CREATED_SUCCESSFULLY);
    }


    @GetMapping(Router.GET_COURSE_BY_ID)
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {

        UserResponseDto userResponseDto = courseServiceImpl.getCourseById(id);

        return ResponseEntity.ok(userResponseDto);
    }


    @GetMapping(Router.GET_ALL_COURSES)
    public ResponseEntity<List<UserResponseDto>> getAll() {

        List<UserResponseDto> courses = courseServiceImpl.getAllCourses();

        return ResponseEntity.ok(courses);
    }


    @DeleteMapping(Router.DELETE_COURSE)
    public ResponseEntity<String> deleteById(@PathVariable Long id) {

        courseServiceImpl.deleteCourse(id);

        return ResponseEntity.ok(Message.DELETED_SUCCESSFULLY);

    }

}
