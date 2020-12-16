package ua.com.rafael.quizzer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.rafael.quizzer.db.entity.Question;
import ua.com.rafael.quizzer.repository.QuestionRepository;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public Question create(final Question question) {
        return questionRepository.saveAndFlush(question);
    }
}
