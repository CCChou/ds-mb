package ds.web.practice.controller;

import ds.web.practice.dto.UserDto;
import ds.web.practice.security.JwtUtils;
import ds.web.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService us;

    @PostMapping("/auth")
    public String authenticate(String name, String password) {
        UserDto dto = us.queryByName(name);
        if (dto.getName().equals(password)) {
            return JwtUtils.createToken(dto.getName());
        }
        return null;
    }
}
