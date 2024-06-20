package org.noob.learnspringdatajpa.repositories;

import org.noob.learnspringdatajpa.entities.Course;
import org.noob.learnspringdatajpa.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositories extends JpaRepository<Course, Long> {
}
