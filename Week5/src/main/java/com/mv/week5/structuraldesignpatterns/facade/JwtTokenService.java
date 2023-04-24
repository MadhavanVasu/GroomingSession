package com.mv.week5.structuraldesignpatterns.facade;

import java.util.Map;

public class JwtTokenService implements TokenService {
    @Override
    public String generateToken(Map<String, Object> claims) {
        // Token generation logic
        // using io.jsonwebtoken library to generate token
        // builder(), setClaims(), setExpiration() methods
        return "Bearer JWT Token";
    }

    @Override
    public boolean validateToken(String token) {
        return false;
    }
}
