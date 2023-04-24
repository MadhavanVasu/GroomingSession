package com.mv.week5.structuraldesignpatterns.facade;

import java.util.Map;

public class FernetTokenService implements TokenService {
    @Override
    public String generateToken(Map<String, Object> claims) {
        // Fernet token generation logic
        return "Fernet token";
    }

    @Override
    public boolean validateToken(String token) {
        return false;
    }
}
