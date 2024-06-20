package org.noob.learnspringdatajpa.Dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.noob.learnspringdatajpa.entities.Coordinator;
import org.noob.learnspringdatajpa.entities.Trainee;

import java.util.Set;

public record TrainerDto(
        Coordinator coordinator,
        Set<Trainee> trainees
) {
}
