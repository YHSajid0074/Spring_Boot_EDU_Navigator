package org.Edu.navigator.config.Authentication.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RefreshToken", indexes = {
        @Index(name = "in_refresh_token_user_id", columnList = "user_id")
})
@Builder
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_refresh_token_user_id"))
    private User user;

//    @Column(name = "user_id", insertable = false, updatable = false)
//    private Long userId;

    @NotBlank
    private String refreshToken;

    @NotNull
    private Instant expireTime;

}