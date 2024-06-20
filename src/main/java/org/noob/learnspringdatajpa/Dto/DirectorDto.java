package org.noob.learnspringdatajpa.Dto;

import org.noob.learnspringdatajpa.entities.Coordinator;

import java.util.Set;

public record DirectorDto(
        Set<Coordinator> coordinators
) {
}
