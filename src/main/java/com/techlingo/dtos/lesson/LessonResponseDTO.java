package com.techlingo.dtos.lesson;

import com.techlingo.dtos.question.QuestionResponseDTO;

import java.util.List;

public record LessonResponseDTO(Long id, String title, String description, Double points, Integer index,
                                List<QuestionResponseDTO> questionList) {
}
