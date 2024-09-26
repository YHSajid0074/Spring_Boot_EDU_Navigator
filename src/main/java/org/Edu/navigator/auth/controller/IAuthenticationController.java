package org.Edu.navigator.auth.controller;


import org.Edu.navigator.auth.dtos.requests.LoginRequestDTO;
import org.Edu.navigator.auth.dtos.responses.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationController {
    ResponseEntity<LoginResponseDTO> login(LoginRequestDTO requestDTO );
}