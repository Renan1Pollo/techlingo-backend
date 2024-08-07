package com.techlingo.dtos.answer;

import com.techlingo.domain.question.Question;

public record AnswerDTO(String text, Question question, String feedbackText, boolean correct) {
}
