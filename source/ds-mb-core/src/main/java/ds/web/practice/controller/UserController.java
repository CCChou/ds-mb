package ds.web.practice.controller;

import ds.web.practice.dto.UserDto;
import ds.web.practice.entity.User;
import ds.web.practice.security.JwtUser;
import ds.web.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService us;

    @PreAuthorize("#id == principal.id or hasRole('ROLE_ADMIN')")
    @GetMapping("/users/{id}")
    public UserDto query(@PathVariable int id) {
        return us.query(id);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/users")
    public List<UserDto> list() {
        return us.list();
    }

    @PostMapping("/users")
    public void create(UserDto form) {
        us.create(form);
    }

    @PreAuthorize("#id == principal.id or hasRole('ROLE_ADMIN')")
    @PutMapping("users/{id}")
    public void update(@PathVariable int id,  UserDto form) {
        us.update(id, form);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("users/{id}")
    public void delete(@PathVariable int id) {
        us.delete(id);
    }
}
