package org.Edu.navigator.service.Impl;


import lombok.RequiredArgsConstructor;
import org.Edu.navigator.dto.request.RoleRequestDTO;
import org.Edu.navigator.dto.response.CustomRoleResponseDTO;
import org.Edu.navigator.model.role.Role;
import org.Edu.navigator.repository.role.RoleRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl  {

    private final RoleRepo roleRepository;

    public void create( RoleRequestDTO requestDto ) {
       Role role = new Role();
       role.setRoleType(requestDto.roleType());
       roleRepository.save(role);
    }





    public CustomRoleResponseDTO readOne( Long id ) {
        CustomRoleResponseDTO singleRoleById = roleRepository.findRoleById( id );
        if ( Objects.isNull( singleRoleById ) ) {
            throw new RuntimeException( "Role with id " + id + " not found." );
        }
        return singleRoleById;
    }


    public String delete( Long id ) {
        Role foundRole = roleRepository
                .findById( id )
                .orElseThrow( () -> new RuntimeException( "Role with id " + id + " not found." ) );
        deleteValidator( foundRole );
        roleRepository.delete( foundRole );

        return "Role Deleted Successfully.";
    }

    private RoleRequestDTO cleanDTOFields( RoleRequestDTO requestDto ) {
        return new RoleRequestDTO(
                requestDto.id(),
                requestDto.roleType()
        );
    }


    private void validate( RoleRequestDTO requestDto, Role role ) {
        if ( Objects.isNull( role ) ) {
            Role foundRole = roleRepository.findByRoleType( requestDto.roleType() );

            if ( Objects.nonNull( foundRole ) ) {
                throw new RuntimeException( "Role type already exists." );
            }
        } else {
            if ( ( !( Objects.equals( requestDto.roleType(), role.getRoleType() ) ) && roleRepository.existsByRoleType( requestDto.roleType() ) ) ) {
                throw new RuntimeException( "Role type already exists." );
            }
        }
    }


    private Role toEntityConverter(RoleRequestDTO requestDto, Role role ) {
        if ( Objects.isNull( role ) ) {
            role = new Role();
        }

        role.setId( requestDto.id() );
        role.setRoleType( requestDto.roleType() );

        return role;
    }

    private void deleteValidator( Role role ) {

    }
}
