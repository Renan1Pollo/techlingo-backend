package com.techlingo.controllers;

import com.techlingo.domain.question.Question;
import com.techlingo.dtos.question.QuestionDTO;
import com.techlingo.dtos.question.QuestionResponseDTO;
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

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionDTO questionDTO) {
        questionService.createQuestion(questionDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<?> updateQuestion(@PathVariable Long questionId, @RequestBody QuestionDTO questionDTO) {
        Boolean isUpdated = this.questionService.updateQuestion(questionId, questionDTO);
        return isUpdated ? new ResponseEntity<>(HttpStatus.OK) : ResponseEntity.status(404).body("Question not found");
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

}
