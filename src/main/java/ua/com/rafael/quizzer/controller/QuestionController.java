package ua.com.rafael.quizzer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.rafael.quizzer.db.entity.Question;
import ua.com.rafael.quizzer.service.QuestionService;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> create(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.create(question));
    }
}
