package ds.web.practice.service;

import ds.web.practice.dto.RoleDto;
import ds.web.practice.entity.Role;
import ds.web.practice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDto> list() {
        return roleRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
    }

    private RoleDto convert(Role role) {
        RoleDto dto = new RoleDto();
        dto.setId(role.getId());
        dto.setName(role.getName());
        return dto;
    }
}
