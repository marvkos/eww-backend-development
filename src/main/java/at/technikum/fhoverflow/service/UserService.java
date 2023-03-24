package at.technikum.fhoverflow.service;

import at.technikum.fhoverflow.model.User;
import at.technikum.fhoverflow.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository
                .findByUsername(username);
    }
}
