package com.techlingo.dtos.answer;

import com.techlingo.dtos.question.QuestionDetailsDTO;

public record AnswerDetailsDTO(Long id, String text, QuestionDetailsDTO question, String feedbackText,
                               boolean correct) {
}
