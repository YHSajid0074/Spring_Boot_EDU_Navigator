package org.noob.learnspringdatajpa.repositories;

import org.noob.learnspringdatajpa.entities.Director;
import org.noob.learnspringdatajpa.entities.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepositories extends JpaRepository<Trainee, Long> {
}
