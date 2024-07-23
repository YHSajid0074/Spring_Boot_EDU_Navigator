package org.Edu.navigator.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.Edu.navigator.common.constant.Message;
import org.Edu.navigator.common.routes.ApiConstants;
import org.Edu.navigator.common.routes.Router;
import org.Edu.navigator.dto.request.CourseRequestDto;
import org.Edu.navigator.model.course.Course;
import org.Edu.navigator.service.Impl.CourseServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path= Router.COURSE)
@Tag(name= ApiConstants.COURSE)
public class CourseController {


    public final CourseServiceImpl courseServiceImpl;


    @PostMapping(Router.CREATE_COURSE)
    public ResponseEntity<String> create(@RequestBody CourseRequestDto courseRequestDto) {

        courseServiceImpl.createCourse(courseRequestDto);

        return ResponseEntity.ok(Message.CREATED_SUCCESSFULLY);
    }


    @GetMapping(Router.GET_COURSE_BY_ID)
    public ResponseEntity<Course> getById(@PathVariable Long id) {

        Course course = courseServiceImpl.getCourseById(id);

        return ResponseEntity.ok(course);
    }


    @GetMapping(Router.GET_ALL_COURSES)
    public ResponseEntity<List<Course>> getAll() {

        List<Course> courses = courseServiceImpl.getAllCourses();

        return ResponseEntity.ok(courses);
    }


    @DeleteMapping(Router.DELETE_COURSE)
    public ResponseEntity<String> deleteById(@PathVariable Long id) {

        courseServiceImpl.deleteCourse(id);

        return ResponseEntity.ok(Message.DELETED_SUCCESSFULLY);

    }

}
