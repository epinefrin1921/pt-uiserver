package ba.edu.ssst.ptuiserver.service;


import ba.edu.ssst.ptuiserver.model.dtos.UserDto;
import ba.edu.ssst.ptuiserver.model.entities.User;
import ba.edu.ssst.ptuiserver.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Collection<UserDto> getList() {
        // todo: proper filtering
        return userRepository.findAll().stream()
                .map(this::toPayload)
                .collect(Collectors.toList());
    }

    public UserDto get(Long id) {
        Optional<User> UserOptional = userRepository.findById(id);
        if (UserOptional.isPresent()) {
            return toPayload(UserOptional.get());
        }
        throw new RuntimeException("User with id:" + id + " doesn't exist!");
    }

    public UserDto save(UserDto payload) {
        User User = fromPayload(payload);
        User = userRepository.save(User);
        return toPayload(User);
    }

    public UserDto update(Long id, UserDto payload) {
        get(id);

        User User = fromPayload(payload);
        User.setId(id);
        User = userRepository.save(User);
        return toPayload(User);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private User fromPayload(UserDto payload) {
        User user = new User();
        user.setAdmin(payload.isAdmin());
        user.setBiography(payload.getBiography());
        user.setContact(payload.getContact());
        user.setDob(payload.getDob());
        user.setEmail(payload.getEmail());
        user.setLastName(payload.getLastName());
        user.setFirstName(payload.getFirstName());
        user.setJmbg(payload.getJmbg());
        user.setLocation(payload.getLocation());
        return user;
    }

    private UserDto toPayload(User user) {
        UserDto payload = new UserDto();
        payload.setAdmin(user.isAdmin());
        payload.setBiography(user.getBiography());
        payload.setContact(user.getContact());
        payload.setDob(user.getDob());
        payload.setEmail(user.getEmail());
        payload.setLastName(user.getLastName());
        payload.setFirstName(user.getFirstName());
        payload.setJmbg(user.getJmbg());
        payload.setLocation(user.getLocation());
        return payload;
    }
}

