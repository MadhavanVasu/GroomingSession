package com.mv.week5.structuraldesignpatterns.facade;

import java.util.HashMap;
import java.util.Map;

public class SignInService {

    private TokenService tokenService;

    public SignInService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public String userLogin(String username, String password) {
        // validate credentials
        // if valid generate token using token service and return the token
        // if invalid throw InvalidCredentialsException
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        return tokenService.generateToken(claims);
    }

}
