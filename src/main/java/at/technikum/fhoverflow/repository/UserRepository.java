package at.technikum.fhoverflow.repository;

import at.technikum.fhoverflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
