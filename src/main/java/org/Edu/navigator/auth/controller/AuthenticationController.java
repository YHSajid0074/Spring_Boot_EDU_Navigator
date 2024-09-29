package org.Edu.navigator.auth.controller;

import lombok.RequiredArgsConstructor;
import org.Edu.navigator.auth.dtos.requests.LoginRequestDTO;
import org.Edu.navigator.auth.dtos.responses.LoginResponseDTO;
import org.Edu.navigator.auth.service.IAuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("Log")
public class AuthenticationController implements IAuthenticationController {
    private final IAuthenticationService authenticationService;

    @PostMapping(  )
    @Override
    public ResponseEntity<LoginResponseDTO> login( @RequestBody LoginRequestDTO requestDTO ) {
        return ResponseEntity.ok( authenticationService.login( requestDTO ) );
    }
}