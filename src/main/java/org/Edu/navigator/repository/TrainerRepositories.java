package org.Edu.navigator.repository;

import org.Edu.navigator.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerRepositories extends JpaRepository<Trainer, Long> {

     Trainer findByEmail(String name);

}
