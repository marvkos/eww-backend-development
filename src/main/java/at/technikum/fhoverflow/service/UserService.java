package at.technikum.fhoverflow.service;

import at.technikum.fhoverflow.model.User;
import at.technikum.fhoverflow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository
                .findByUsername(username);
    }
}
