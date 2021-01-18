package ua.com.rafael.quizzer.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ua.com.rafael.quizzer.db.entity.AnswerOption;
import ua.com.rafael.quizzer.db.entity.Question;
import ua.com.rafael.quizzer.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.HttpStatus.OK;
import static ua.com.rafael.quizzer.db.entity.QuestionStrategy.ONE_ANSWER;

class QuestionControllerIntegrationTest extends IntegrationTest {
    private static final String QUESTION_PATH = "/question";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void findAll_shouldFindAllQuestions() {
        ResponseEntity<List<Question>> response =
                testRestTemplate.exchange(QUESTION_PATH, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Question>>() {
                        });
        assertEquals(OK, response.getStatusCode());

        List<Question> actualQuestions = response.getBody();
        assertNotNull(actualQuestions);
        assertEquals(2, actualQuestions.size());
    }

    @Test
    void create_shouldCreateNewQuestion() {
        List<AnswerOption> answerOptions = new ArrayList<>();
        answerOptions.add(AnswerOption.builder().answerOptionText("Answer option 1").build());
        answerOptions.add(AnswerOption.builder().answerOptionText("Answer option 1").build());
        final Question newQuestion = Question.builder()
                .questionText("Question 1")
                .questionStrategy(ONE_ANSWER)
                .answerOptions(answerOptions).build();

        final ResponseEntity<Question> postResponse = testRestTemplate.postForEntity(QUESTION_PATH,
                newQuestion, Question.class);
        assertEquals(OK, postResponse.getStatusCode());

        Question savedQuestion = postResponse.getBody();
        assertNotNull(savedQuestion);
        assertNotNull(savedQuestion.getId());

        final ResponseEntity<List<Question>> getResponse =
                testRestTemplate.exchange(QUESTION_PATH, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Question>>() {
                        });
        assertEquals(OK, postResponse.getStatusCode());

        List<Question> actualQuestions = getResponse.getBody();
        assertNotNull(actualQuestions);
        assertEquals(3, actualQuestions.size());

        questionRepository.deleteById(savedQuestion.getId());
    }
}
