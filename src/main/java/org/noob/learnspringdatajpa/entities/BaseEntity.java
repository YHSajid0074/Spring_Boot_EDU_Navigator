package org.noob.learnspringdatajpa.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            nullable = false

    )
    private String fullName;
    @Column(
            unique = true,
            nullable = false
    )
    private String username;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
}
