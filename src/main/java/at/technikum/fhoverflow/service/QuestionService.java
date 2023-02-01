package at.technikum.fhoverflow.service;

import at.technikum.fhoverflow.exception.EntityNotFoundException;
import at.technikum.fhoverflow.model.Question;
import at.technikum.fhoverflow.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question update(Long id, Question updatedQuestion) {
        Question question = questionRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        question.setTitle(updatedQuestion.getTitle());
        question.setDescription(updatedQuestion.getDescription());

        return questionRepository.save(question);
    }
}
