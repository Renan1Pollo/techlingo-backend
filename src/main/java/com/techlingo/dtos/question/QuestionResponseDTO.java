package com.techlingo.dtos.question;

import com.techlingo.dtos.answer.AnswerResponseDTO;

import java.util.List;

public record QuestionResponseDTO(Long id, String description, Integer index, List<AnswerResponseDTO> answerList) {
}
