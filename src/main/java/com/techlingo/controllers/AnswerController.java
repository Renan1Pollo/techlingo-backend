package com.techlingo.controllers;

import com.techlingo.domain.answer.Answer;
import com.techlingo.dtos.answer.AnswerDTO;
import com.techlingo.dtos.answer.AnswerResponseDTO;
import com.techlingo.services.AnswerService;
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
}
