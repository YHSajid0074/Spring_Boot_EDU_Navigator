package org.Edu.navigator.services;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.entities.Course;
import org.Edu.navigator.repositories.CourseRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServices {
    private final CourseRepositories courseRepositories;
    public Course create(Course course){
       return courseRepositories.save(course);
    }

    public Course get(Long id){
        Course course = courseRepositories.findById(id).get();
        return course;
    }

    public List<Course> getAll(){
      List< Course >course = courseRepositories.findAll();
      return course;
    }

    public void delete(Long id){
        courseRepositories.deleteById(id);
    }

}
