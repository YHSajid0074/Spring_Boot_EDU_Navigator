package org.Edu.navigator.service.Impl;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.dto.request.UserRequestDTO;
import org.Edu.navigator.dto.request.UserRolesRequestDTO;
import org.Edu.navigator.dto.response.CustomUserResponseDTO;
import org.Edu.navigator.model.role.Role;
import org.Edu.navigator.model.user.User;
import org.Edu.navigator.repository.role.RoleRepo;
import org.Edu.navigator.repository.user.UserRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService  {
    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepository;


    public void create( UserRequestDTO requestDto ) {
        User user = new User();
        user.setUsername( requestDto.username() );
        user.setEmail( requestDto.email() );
        user.setPassword( passwordEncoder.encode(requestDto.password() ));
        userRepository.save( user );
    }

    public User readOne(Long id ) {
       User singleUserById = userRepository.findUserByUserId(id);
        if ( Objects.isNull( singleUserById ) ) {
            throw new RuntimeException( "User with id " + id + " not found." );
        }
        return singleUserById;
    }




    public User setUserRoles( UserRolesRequestDTO requestDTO ) {
        User foundUser = userRepository.findUserByUserId( requestDTO.userId() );

        if ( Objects.isNull( foundUser ) ) {
            throw new RuntimeException( "User with id " + requestDTO.userId() + " not found." );
        }

        Set<Role> foundRoles = roleRepository.findAllByIdIn( requestDTO.roleIds() );
        foundUser.getRoles().addAll( foundRoles );

      return  userRepository.save( foundUser );

    }


}