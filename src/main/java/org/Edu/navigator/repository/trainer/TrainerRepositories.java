package org.Edu.navigator.repository.trainer;

import org.Edu.navigator.model.trainer.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepositories extends JpaRepository<Trainer, Long> {

     Trainer findByEmail(String name);

}
