package ua.com.rafael.quizzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.rafael.quizzer.db.entity.Question;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
}
