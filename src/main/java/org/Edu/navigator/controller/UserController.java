package org.Edu.navigator.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.dto.request.UserRequestDTO;
import org.Edu.navigator.dto.request.UserRolesRequestDTO;
import org.Edu.navigator.dto.response.CustomUserResponseDTO;
import org.Edu.navigator.model.user.User;
import org.Edu.navigator.service.Impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(  )
public class UserController  {
    private final UserService userService;

    @PostMapping( )
    public ResponseEntity< String > create( UserRequestDTO requestDto ) {
        userService.create(requestDto);
       return ResponseEntity.ok("Successfully created user");
    }


    @GetMapping( "{id}" )
    public ResponseEntity<User> readOne(@PathVariable( "id" ) Long id ) {
        return ResponseEntity
                .ok()
                .body( userService.readOne( id ) );
    }


    @PostMapping( "change-roles" )
    public ResponseEntity< User> setUserRoles( @RequestBody UserRolesRequestDTO requestDTO ) {
        return ResponseEntity
                .ok()
                .body( userService.setUserRoles( requestDTO ) );
    }
}