package org.Edu.navigator.model.trainer;
import java.util.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.Edu.navigator.model.baseEntity.BaseEntity;
import org.Edu.navigator.model.coordinator.Coordinator;
import org.Edu.navigator.model.trainee.Trainee;

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
