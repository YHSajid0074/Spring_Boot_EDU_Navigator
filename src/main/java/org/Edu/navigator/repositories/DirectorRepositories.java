package org.Edu.navigator.repositories;

import org.Edu.navigator.Dto.DirectorDto;
import org.Edu.navigator.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepositories extends JpaRepository<Director, Long> {
public Director findByEmail(String email);
}
