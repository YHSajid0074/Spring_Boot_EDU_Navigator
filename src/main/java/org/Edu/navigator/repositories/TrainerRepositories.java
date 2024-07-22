package org.Edu.navigator.repositories;

import org.Edu.navigator.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepositories extends JpaRepository<Trainer, Long> {

    public Trainer findByEmail(String name);

}
