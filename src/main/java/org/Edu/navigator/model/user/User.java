package org.Edu.navigator.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.Edu.navigator.model.baseEntity.BaseEntity;
import org.Edu.navigator.model.role.Role;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SuperBuilder
@SQLRestriction( "is_active = TRUE" )
@SQLDelete( sql = "UPDATE _user SET is_active = FALSE WHERE id = ?" )
@Entity
@Table( name = "_user" )
public class User extends BaseEntity {

    @Column( nullable = false )
    private String username;

    @Column( nullable = false )
    private String email;

    @Column( nullable = false )
    private String password;

    @ManyToMany(
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH },
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "_user_roles",
            joinColumns = @JoinColumn( name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "roles_id" )
    )
    private Set<Role> roles = new LinkedHashSet<>();
}
