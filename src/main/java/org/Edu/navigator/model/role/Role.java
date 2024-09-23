package org.Edu.navigator.model.role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.Edu.navigator.model.baseEntity.BaseEntity;
import org.Edu.navigator.model.user.User;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SuperBuilder
//@SQLRestriction( "is_active = TRUE" )
@SQLDelete( sql = "UPDATE role SET is_active = FALSE WHERE id = ?" )
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false )
    private String roleType = "USER";

    @ManyToMany(
            mappedBy = "roles",
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH }
    )
    private Set<User> users = new LinkedHashSet<>();

    public Role( String roleType ) {
        this.roleType = roleType;
    }
}
