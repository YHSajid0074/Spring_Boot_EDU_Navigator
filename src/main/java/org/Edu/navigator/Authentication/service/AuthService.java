package org.Edu.navigator.Authentication.service;

public interface AuthService {

    JwtResponse authenticateUser(LoginRequest loginRequest);
}
