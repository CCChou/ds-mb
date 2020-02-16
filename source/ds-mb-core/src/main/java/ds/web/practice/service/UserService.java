package ds.web.practice.service;

import ds.web.practice.dto.UserDto;
import ds.web.practice.entity.User;
import ds.web.practice.exception.UserNotFoundException;
import ds.web.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void create(UserDto form) {
        User user = new User();
        user.setName(form.getName());
        user.setPassword(form.getPassword());
        // TODO
        user.setRoles(null);
        repository.save(user);
    }

    public UserDto queryByName(String name) {
        User user = repository.findByName(name);
        return toDto(user);
    }

    public UserDto query(int id) {
        Optional<User> userOption = repository.findById(id);
        if (!userOption.isPresent()) {
            throw new UserNotFoundException();
        }
        return toDto(userOption.get());
    }

    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return dto;
    }

    public List<UserDto> list() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }
}
