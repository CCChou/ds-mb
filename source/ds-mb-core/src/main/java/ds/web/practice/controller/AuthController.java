package ds.web.practice.controller;

import ds.web.practice.security.JwtUtils;
import ds.web.practice.service.AuthenticateService;
import ds.web.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticateService authenticateService;

    @Autowired
    private UserService us;

    @PostMapping("/auth")
    public String authenticate(String name, String password) {
        return authenticateService.authenticateAndGetToken(name, password);
    }
}
