package org.Edu.navigator.Authentication.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CustomUserDetails implements UserDetails {
    private static final String ERROR_MESSAGE = "Your role has not been assigned by the Administrator. Please contact the administrator for role assignment.";

    private final Long id;

    private final String username;

    private final String fullName;

    @JsonIgnore
    private final String password;

    private final Long roleId;

    private final String role;

    private final Collection<? extends GrantedAuthority> authorities;


    public CustomUserDetails(Long id, String username, String fullName, String password, Long roleId, String role,
                             Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.roleId = roleId;
        this.role = role;
        this.authorities = authorities;
    }


    public static CustomUserDetails build(User user) {

        if(Objects.isNull(user.getRole())){
            throw new RuntimeException(ERROR_MESSAGE);
        }

        List<GrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority("ROLE_"+user.getRole().getName()));

        return new CustomUserDetails(
                user.getId(),
                user.getUsername(),
                user.getFullName(),
                user.getPassword(),
                user.getRole().getId(),
                user.getRole().getName(),
                authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CustomUserDetails user = (CustomUserDetails) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : this.getClass().hashCode();
    }

    public Long getRoleId() {
        return roleId;
    }
}

