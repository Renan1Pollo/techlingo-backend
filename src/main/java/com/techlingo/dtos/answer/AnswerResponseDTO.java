package com.techlingo.dtos.answer;

import com.techlingo.domain.question.Question;

public record AnswerResponseDTO(String text, String feedbackText, boolean correct) {
}
