package org.noob.learnspringdatajpa.repositories;

import org.noob.learnspringdatajpa.entities.Director;
import org.noob.learnspringdatajpa.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepositories extends JpaRepository<Trainer, Long> {
}
