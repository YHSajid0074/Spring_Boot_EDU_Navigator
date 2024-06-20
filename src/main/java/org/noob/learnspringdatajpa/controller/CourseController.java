package org.noob.learnspringdatajpa.controller;

import lombok.RequiredArgsConstructor;
import org.noob.learnspringdatajpa.entities.Course;
import org.noob.learnspringdatajpa.services.CourseServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("Course")
public class CourseController {
public final CourseServices courseServices;
@PostMapping("post")
    public ResponseEntity<String> create(@RequestBody Course course){
    courseServices.create(course);
    return ResponseEntity.ok("The work is done brow");
}
@GetMapping("FindById/{id}")
public ResponseEntity<Course> get(@PathVariable Long id){
  Course course = courseServices.get(id);
  return ResponseEntity.ok(course);
}
@GetMapping("GetAll")
public ResponseEntity<List<Course>> getAll(){
    List<Course> courses = courseServices.getAll();
    return ResponseEntity.ok(courses);
}
@DeleteMapping("delete/{id}")
public ResponseEntity<String> delete(@PathVariable long id){
    courseServices.delete(id);
    return ResponseEntity.ok("Successfully deleted the course");
}

}
