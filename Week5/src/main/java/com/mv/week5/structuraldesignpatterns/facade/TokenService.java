package com.mv.week5.structuraldesignpatterns.facade;

import java.util.Map;

public interface TokenService {

    public String generateToken(Map<String, Object> claims);

    public boolean validateToken(String token);

}
