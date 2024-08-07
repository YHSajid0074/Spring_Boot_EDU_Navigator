package org.Edu.navigator.model.coordinator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.Edu.navigator.model.director.Director;
import org.Edu.navigator.model.trainer.Trainer;
import org.Edu.navigator.model.baseEntity.BaseEntity;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coordinator extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    Director director;

    @OneToMany(mappedBy = "coordinator")
    Set<Trainer> trainers;
}
