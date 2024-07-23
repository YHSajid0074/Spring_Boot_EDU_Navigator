package org.Edu.navigator.repository;

import org.Edu.navigator.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepositories extends JpaRepository<Director, Long> {

public Director findByEmail(String email);

}
