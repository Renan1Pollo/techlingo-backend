package com.techlingo.controllers;

import com.techlingo.domain.question.Question;
import com.techlingo.dtos.question.QuestionDTO;
import com.techlingo.dtos.question.QuestionDetailsDTO;
import com.techlingo.dtos.question.QuestionResponseDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private EntityMappingService entityMappingService;

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionDTO questionDTO) {
        Question question = questionService.createQuestion(questionDTO);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<?> updateQuestion(@PathVariable Long questionId, @RequestBody QuestionDTO questionDTO) {
        try {
            Question updatedQuestion = questionService.updateQuestion(questionId, questionDTO);
            return ResponseEntity.ok(updatedQuestion);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body("Question not found");
        }
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<?> deleteQuestionById(@PathVariable Long questionId) {
        Boolean isDeleted = this.questionService.deleteQuestionById(questionId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(404).body("Question not found");
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getAllQuestions() {
        List<QuestionResponseDTO> questions = this.questionService.getAllQuestionDTOs();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/all")
        public ResponseEntity<List<QuestionDetailsDTO>> getAllQuestionDetails() {
        List<QuestionDetailsDTO> questions = this.questionService.getAllQuestionDetails();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<?> findQuestionById(@PathVariable Long questionId) {
        try {
            Question question = this.questionService.findQuestionById(questionId);
            return ResponseEntity.ok(entityMappingService.mapToQuestionDetailsDTO(question));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question Not Found");
        }
    }

}
