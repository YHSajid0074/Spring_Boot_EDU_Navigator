package org.Edu.navigator.repository.role;

import org.Edu.navigator.dto.response.CustomRoleResponseDTO;
import org.Edu.navigator.model.role.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RoleRepo extends JpaRepository<Role, Long > {
    Role findByRoleType( String roleType );

    Boolean existsByRoleType( String roleType );

    @EntityGraph( attributePaths = { "users" } )
    @Query( """
                SELECT
                    role
                FROM Role role
            """ )
    Page<CustomRoleResponseDTO> findAllRoles(Pageable pageable );

    @EntityGraph( attributePaths = { "users" } )
    Set< Role > findAllByIdIn( Set< Long > ids );

    CustomRoleResponseDTO findRoleById(Long id);
}
