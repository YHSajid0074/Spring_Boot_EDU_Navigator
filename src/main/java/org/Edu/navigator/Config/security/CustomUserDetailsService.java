package org.Edu.navigator.Config.security;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.model.role.Role;
import org.Edu.navigator.model.user.User;
import org.Edu.navigator.repository.user.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        User foundUser = userRepository.findByUsernameOrEmail( username.strip(), username.strip() );
        if ( Objects.isNull( foundUser ) ) {
            throw new UsernameNotFoundException( username );
        }

        Set< String > grantedAuthorities = foundUser
                .getRoles()
                .stream()
                .map( Role::getRoleType )
                .collect( Collectors.toSet() );

        return new UserPrinciple(foundUser);
    }
}