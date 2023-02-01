package at.technikum.fhoverflow.controller;

import at.technikum.fhoverflow.model.Question;
import at.technikum.fhoverflow.repository.QuestionRepository;
import at.technikum.fhoverflow.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Question create(@RequestBody @Valid Question question) {
        return questionService.save(question);
    }

    @GetMapping()
    public List<Question> readAll() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public Question read(@PathVariable Long id) {
        return questionService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public Question update(@PathVariable Long id, @RequestBody @Valid Question question) {
        return questionService.update(id, question);
    }

    @DeleteMapping("/{id}")
    public Question delete(@PathVariable Long id) {
        return null;
    }
}
