package org.noob.learnspringdatajpa.Dto;

import org.noob.learnspringdatajpa.entities.Director;
import org.noob.learnspringdatajpa.entities.Trainer;

import java.util.Set;

public record CoordinatorDto(
        Director director,
        Set<Trainer> trainers
) {
}
