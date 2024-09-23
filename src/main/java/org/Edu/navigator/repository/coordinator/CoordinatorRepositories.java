package org.Edu.navigator.repository.coordinator;

import org.Edu.navigator.dto.response.CoordinatorResponseDto;
import org.Edu.navigator.model.coordinator.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoordinatorRepositories extends JpaRepository<Coordinator, Long> {

    @Query("""
SELECT c.id AS id,
c.username AS username,
c.fullName AS fullname,
c.email AS email
FROM Coordinator c
""")
    List<CoordinatorResponseDto> getAllCoordinator();

    @Query("""
SELECT c.id AS id,
c.username AS username,
c.fullName AS fullname,
c.email AS email
FROM Coordinator c Where c.email = :email
""")
    Optional <CoordinatorResponseDto> findByEmail(String email);


    @Query("""
SELECT c.id AS id,
c.username AS username,
c.fullName AS fullname,
c.email AS email
FROM Coordinator c
where c.id=id
""")
     CoordinatorResponseDto findCoordinatorById(@Param("id") Long id);

}
