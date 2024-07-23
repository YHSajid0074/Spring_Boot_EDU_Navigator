package org.Edu.navigator.model.director;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.Edu.navigator.model.baseEntity.BaseEntity;
import org.Edu.navigator.model.coordinator.Coordinator;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Director extends BaseEntity {

    @OneToMany(mappedBy = "director", orphanRemoval = true, cascade = CascadeType.ALL)
    Set<Coordinator> coordinators;

}
