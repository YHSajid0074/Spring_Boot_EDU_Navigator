package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.dto.request.RoleRequestDTO;
import org.Edu.navigator.dto.response.CustomRoleResponseDTO;
import org.Edu.navigator.model.role.Role;
import org.Edu.navigator.service.Impl.RoleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Role")
public class RoleController  {
    private final RoleServiceImpl roleService;

    @PostMapping()
    public ResponseEntity<String> create(RoleRequestDTO requestDto ) {
        roleService.create( requestDto );
        return  ResponseEntity.ok( "Created" );
    }


    @GetMapping( "{id}" )
    public ResponseEntity< CustomRoleResponseDTO > readOne( @PathVariable( "id" ) Long id ) {
        return ResponseEntity
                .ok()
                .body( roleService.readOne( id ) );
    }


    @DeleteMapping( "{id}" )
    public ResponseEntity<String> delete( @PathVariable( "id" ) Long id ) {
        roleService.delete( id );
        return new ResponseEntity<>( "Successfully deleted", HttpStatus.OK );
    }
}

