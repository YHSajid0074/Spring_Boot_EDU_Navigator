package org.Edu.navigator.repositories;

import org.Edu.navigator.Dto.TraineeDto;
import org.Edu.navigator.entities.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepositories extends JpaRepository<Trainee, Long> {

    public Trainee findByEmail(String name);
}
