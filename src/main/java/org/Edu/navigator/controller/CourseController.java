package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.Dto.CourseDto;
import org.Edu.navigator.entities.Course;
import org.Edu.navigator.services.CourseServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("Course")
public class CourseController {


public final CourseServices courseServices;


@PostMapping("post")
    public ResponseEntity<String> create(@RequestBody CourseDto courseDto){
    courseServices.createCourse(courseDto);
    return ResponseEntity.ok("Successfully Created");
}


@GetMapping("FindById/{id}")
public ResponseEntity<Course> get(@PathVariable Long id){
  Course course = courseServices.getCourseById(id);
  return ResponseEntity.ok(course);
}


@GetMapping("GetAll")
public ResponseEntity<List<Course>> getAll(){
    List<Course> courses = courseServices.getAllCourses();
    return ResponseEntity.ok(courses);
}


@DeleteMapping("delete/{id}")
public ResponseEntity<String> delete(@PathVariable long id){
    courseServices.deleteCourse(id);
    return ResponseEntity.ok("Successfully deleted the course");
}

}
