package org.Edu.navigator.auth.service;


import org.Edu.navigator.auth.dtos.requests.LoginRequestDTO;
import org.Edu.navigator.auth.dtos.responses.LoginResponseDTO;

public interface IAuthenticationService {
    LoginResponseDTO login(LoginRequestDTO requestDTO );
}