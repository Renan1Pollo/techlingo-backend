package com.techlingo.controllers;

import com.techlingo.domain.answer.Answer;
import com.techlingo.domain.question.Question;
import com.techlingo.dtos.answer.AnswerDTO;
import com.techlingo.dtos.answer.AnswerDetailsDTO;
import com.techlingo.dtos.answer.AnswerResponseDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.services.AnswerService;
import com.techlingo.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private EntityMappingService entityMappingService;

    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody AnswerDTO answerDTO) {
        answerService.createAnswer(answerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{answerId}")
    public ResponseEntity<?> updateAnswer(@PathVariable Long answerId, @RequestBody AnswerDTO answerDTO) {
        Boolean isUpdated = this.answerService.updateAnswer(answerId, answerDTO);
        return isUpdated ? new ResponseEntity<>(HttpStatus.OK) : ResponseEntity.status(404).body("Answer not found");
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity<?> deleteAnswerById(@PathVariable Long answerId) {
        Boolean isDeleted = this.answerService.deleteAnswerById(answerId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(404).body("Answer not found");
    }

    @GetMapping
    public ResponseEntity<List<AnswerResponseDTO>> getAllAnswers() {
        List<AnswerResponseDTO> answers = this.answerService.getAllAnswerDTOs();
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AnswerDetailsDTO>> getAllAnswersDetails() {
        List<AnswerDetailsDTO> answers = this.answerService.getAllAnswersDetails();
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<?> findAnswerById(@PathVariable Long answerId) {
        try {
            Answer answer = this.answerService.findAnswerById(answerId);
            return ResponseEntity.ok(entityMappingService.mapToAnswerDetailsDTO(answer));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Answer Not Found");
        }
    }

    @GetMapping("/questions")
    public ResponseEntity<?> findAnswerByQuestionId(@RequestParam Long questionId) {
        try {
            Question question = questionService.findQuestionById(questionId);
            List<AnswerDetailsDTO> answers = this.answerService.findAnswerByQuestion(question);
            return answers.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Answer Not Found") : ResponseEntity.ok(answers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Answer Not Found");
        }
    }

}
