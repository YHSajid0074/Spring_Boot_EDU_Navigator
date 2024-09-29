package org.Edu.navigator.auth;

import lombok.*;
import org.Edu.navigator.model.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomUserDetails implements UserDetails, Principal, Serializable {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Set< String > roles = new HashSet<>();

    @Override
    public String getName() {
        return username;
    }

    @Override
    public Collection< ? extends GrantedAuthority > getAuthorities() {
        return roles
                .stream()
                .map( SimpleGrantedAuthority::new )
                .collect( Collectors.toSet() );
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}