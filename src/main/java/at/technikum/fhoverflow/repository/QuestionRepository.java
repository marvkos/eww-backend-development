package at.technikum.fhoverflow.repository;

import at.technikum.fhoverflow.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository
        extends JpaRepository<Question, Long> {
}
