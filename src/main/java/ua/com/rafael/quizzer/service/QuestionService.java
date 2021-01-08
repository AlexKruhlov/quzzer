package ua.com.rafael.quizzer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.rafael.quizzer.db.entity.Question;
import ua.com.rafael.quizzer.repository.QuestionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question create(final Question question) {
        return questionRepository.saveAndFlush(question);
    }
}
