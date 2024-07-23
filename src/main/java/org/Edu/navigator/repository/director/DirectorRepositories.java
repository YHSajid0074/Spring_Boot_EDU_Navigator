package org.Edu.navigator.repository.director;

import org.Edu.navigator.model.director.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepositories extends JpaRepository<Director, Long> {

public Director findByEmail(String email);

}
