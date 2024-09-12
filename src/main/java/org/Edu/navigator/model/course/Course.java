package org.Edu.navigator.model.course;

import java.io.Serializable;
import java.util.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.Edu.navigator.model.trainee.Trainee;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course implements Serializable {

    private static final long serialVersionUID = 139L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer duration;

    @ManyToMany(mappedBy = "courses")
    Set<Trainee> trainee;
}
