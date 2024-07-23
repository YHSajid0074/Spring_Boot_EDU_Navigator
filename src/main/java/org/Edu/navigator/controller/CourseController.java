package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.dto.request.CourseRequestDto;
import org.Edu.navigator.model.Course;
import org.Edu.navigator.service.Impl.CourseServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("Course")
public class CourseController {


    public final CourseServiceImpl courseServiceImpl;


    @PostMapping("post")
    public ResponseEntity<String> create(@RequestBody CourseRequestDto courseRequestDto) {

        courseServiceImpl.createCourse(courseRequestDto);


        return ResponseEntity.ok("Successfully Created");
    }


    @GetMapping("FindById/{id}")
    public ResponseEntity<Course> get(@PathVariable Long id) {

        Course course = courseServiceImpl.getCourseById(id);

        return ResponseEntity.ok(course);
    }


    @GetMapping("GetAll")
    public ResponseEntity<List<Course>> getAll() {

        List<Course> courses = courseServiceImpl.getAllCourses();

        return ResponseEntity.ok(courses);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        courseServiceImpl.deleteCourse(id);

        return ResponseEntity.ok("Successfully deleted the course");

    }

}
