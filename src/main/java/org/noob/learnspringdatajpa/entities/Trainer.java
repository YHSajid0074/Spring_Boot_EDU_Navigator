package org.noob.learnspringdatajpa.entities;
import java.util.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trainer extends BaseEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    Coordinator coordinator;
    @OneToMany(mappedBy = "trainer")
    Set<Trainee>trainees;
}
