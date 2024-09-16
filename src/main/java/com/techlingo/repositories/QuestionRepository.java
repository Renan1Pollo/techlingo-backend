package com.techlingo.repositories;

import com.techlingo.domain.lesson.Lesson;
import com.techlingo.domain.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Optional<Question> findQuestionById(Long id);

    Optional<Question> findQuestionByLesson(Lesson lesson);
}

