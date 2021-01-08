package ua.com.rafael.quizzer.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import ua.com.rafael.quizzer.db.entity.Question;
import ua.com.rafael.quizzer.repository.QuestionRepository;

class QuestionServiceTest extends UnitTest {
    private static final Question EMPTY_QUESTION = new Question();

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService underTest;

    @Test
    void create_shouldCreateNewQuestion() {
        underTest.create(EMPTY_QUESTION);
        Mockito.verify(questionRepository).saveAndFlush(EMPTY_QUESTION);
    }

    @Test
    void findAll_shouldFindAllQuestions() {
        underTest.findAll();
        Mockito.verify(questionRepository).findAll();
    }

    @AfterEach
    void tearDown() {
        Mockito.reset(questionRepository);
    }
}
