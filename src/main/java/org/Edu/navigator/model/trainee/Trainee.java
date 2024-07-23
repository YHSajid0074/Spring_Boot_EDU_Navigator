package org.Edu.navigator.model.trainee;

import java.util.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.Edu.navigator.model.trainer.Trainer;
import org.Edu.navigator.model.baseEntity.BaseEntity;
import org.Edu.navigator.model.course.Course;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trainee extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    Trainer trainer;

    @ManyToMany
    Set<Course> courses;
}
