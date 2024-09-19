package org.Edu.navigator.repository.user;

import org.Edu.navigator.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Long > {

    @EntityGraph( attributePaths = { "roles" } )
    User findByUsernameOrEmail( String username, String email );

    boolean existsByUsername( String username );

    boolean existsByEmail( String email );

    @EntityGraph( attributePaths = { "roles" } )
    @Query( """
                SELECT
                    user
                FROM
                    User user
                WHERE
                    user.id = :id
            """ )
    User findUserByUserId( @Param( "id" ) Long id );
}