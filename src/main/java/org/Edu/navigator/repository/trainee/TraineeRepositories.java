package org.Edu.navigator.repository.trainee;

import org.Edu.navigator.model.trainee.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepositories extends JpaRepository<Trainee, Long> {

    public Trainee findByEmail(String name);

}
