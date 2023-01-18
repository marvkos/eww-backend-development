package at.technikum.fhoverflow.controller;

import at.technikum.fhoverflow.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private List<Question> questions;

    public QuestionController() {
        this.questions = new ArrayList<>();
        this.questions.add(new Question(12L, "Hello World!", "How does it work?"));
        this.questions.add(new Question(28L, "Help!", "How does it work?"));
        this.questions.add(new Question(36L, "Is JS good", "How does it work?"));
    }

    @PostMapping()
    public Question create() {
        return null;
    }

    @GetMapping()
    public List<Question> readAll() {
        return this.questions;
    }

    @GetMapping("/{id}")
    public Question read(@PathVariable Long id) {
        for (Question q: this.questions) {
            if (id.equals(q.getId())) {
                return q;
            }
        }

        // 404 Question not found
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public Question update(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public Question delete(@PathVariable Long id) {
        return null;
    }
}
