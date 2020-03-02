package ds.web.practice.controller;

import ds.web.practice.dto.RoleDto;
import ds.web.practice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/roles")
    public List<RoleDto> list() {
        return roleService.list();
    }
}
