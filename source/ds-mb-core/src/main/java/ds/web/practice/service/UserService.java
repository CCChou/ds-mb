package ds.web.practice.service;

import ds.web.practice.dto.UserDto;
import ds.web.practice.entity.Role;
import ds.web.practice.entity.User;
import ds.web.practice.exception.UserNotFoundException;
import ds.web.practice.repository.RoleRepository;
import ds.web.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void create(UserDto form) {
        User user = new User();
        user.setName(form.getName());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setRoles(toRoles(form.getRoleIds()));
        userRepository.save(user);
    }

    private List<Role> toRoles(List<Integer> roleIds) {
        return roleRepository.findAllById(roleIds);
    }

    public UserDto query(int id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return toDto(user);
    }

    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return dto;
    }

    public List<UserDto> list() {
        return userRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public void update(int id, UserDto form) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        user.setName(form.getName());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setRoles(toRoles(form.getRoleIds()));
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
