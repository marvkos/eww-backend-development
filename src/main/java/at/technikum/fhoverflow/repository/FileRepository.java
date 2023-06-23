package at.technikum.fhoverflow.repository;

import at.technikum.fhoverflow.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository
        extends JpaRepository<File, Long> {
}
