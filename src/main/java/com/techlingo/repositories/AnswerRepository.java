package com.techlingo.repositories;

import com.techlingo.domain.answer.Answer;
import com.techlingo.domain.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Optional<Answer> findAnswerById(Long id);
    Optional<List<Answer>> findAnswerByQuestion(Question question);
}
