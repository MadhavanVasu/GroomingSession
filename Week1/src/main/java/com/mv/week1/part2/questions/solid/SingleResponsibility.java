package com.mv.week1.part2.questions.solid;

class BadLoginService{
    // Login Service should have only one responsibility
    // i.e. it should just authenticate the user based on the credentials
    // it should not have the logic of token generation
    // It should have single responsibility i.e. authenticating user
    public String login(String username, String password) {
        // authenticate login and generate jwt token
        // logic for generating token
        return "jwt token";
    }

}

class JwtTokenService
{
    public String generateJwtToken(String username)
    {
        return "jwt token";
    }
}

class LoginService{
    // Here the login service has just single responsibility
    // i.e. to authenticate user
    // JWT token generation is done by JWT Token Service class
    JwtTokenService jwtTokenService;

    public LoginService(JwtTokenService jwtTokenService)
    {
        this.jwtTokenService = jwtTokenService;
    }

    public String login(String username, String password)
    {
        // authenticate user
        return jwtTokenService.generateJwtToken(username);
    }


}

public class SingleResponsibility {

    public static void main(String[] args) {
        LoginService loginService = new LoginService(new JwtTokenService());
        System.out.println(loginService.login("admin", "admin"));
    }
}
