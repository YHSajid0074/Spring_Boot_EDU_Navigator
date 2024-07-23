package org.Edu.navigator.repository;

import org.Edu.navigator.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepositories extends JpaRepository<Trainee, Long> {

    public Trainee findByEmail(String name);

}
