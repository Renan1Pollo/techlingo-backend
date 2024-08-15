package com.techlingo.services;

import com.techlingo.domain.lesson.Lesson;
import com.techlingo.domain.question.Question;
import com.techlingo.dtos.question.QuestionDTO;
import com.techlingo.dtos.question.QuestionDetailsDTO;
import com.techlingo.dtos.question.QuestionResponseDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository repository;

    @Autowired
    private EntityMappingService entityMappingService;

    public Question createQuestion(QuestionDTO data) {
        Question newQuestion = new Question(data);
        repository.save(newQuestion);
        return newQuestion;
    }

    public Boolean updateQuestion(Long id, QuestionDTO data) {
        Optional<Question> questionOptional = this.repository.findQuestionById(id);

        if (questionOptional.isPresent()) {
            Question existingQuestion = questionOptional.get();
            existingQuestion = new Question(data);
            existingQuestion.setId(id);
            repository.save(existingQuestion);
            return true;
        }

        return false;
    }

    public Boolean deleteQuestionById(Long id) {
        Optional<Question> questionOptional = this.repository.findQuestionById(id);

        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            question.getAnswers().clear();
            repository.deleteById(question.getId());
            return true;
        }

        return false;
    }

    public List<QuestionResponseDTO> getAllQuestionDTOs() {
        List<Question> questions = getAllQuestions();
        return questions.stream()
                .map(entityMappingService::mapToQuestionResponseDTO)
                .collect(Collectors.toList());
    }

    public List<QuestionDetailsDTO> getAllQuestionDetails() {
        List<Question> questions = getAllQuestions();
        return questions.stream()
                .map(entityMappingService::mapToQuestionDetailsDTO)
                .collect(Collectors.toList());
    }

    public List<Question> getAllQuestions() {
        return this.repository.findAll();
    }

    public Question findQuestionById(Long id) throws Exception {
        return this.repository.findQuestionById(id).orElseThrow(() -> new Exception("Questão não encontrada"));
    }

    public Question findQuestionByLesson(Lesson lesson) throws Exception {
        return this.repository.findQuestionByLesson(lesson).orElseThrow(() -> new Exception("Questão não encontrada"));
    }

}
