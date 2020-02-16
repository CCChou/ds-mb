package ds.web.practice.controller;

import ds.web.practice.dto.UserDto;
import ds.web.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService us;

    @GetMapping("/users/{id}")
    public UserDto query(@PathVariable int id) {
        return us.query(id);
    }

    @GetMapping("/users")
    public List<UserDto> list() {
        return us.list();
    }

    @PostMapping("/users")
    public void create(UserDto form) {
        us.create(form);
    }
}
