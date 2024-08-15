package com.techlingo.dtos.question;

import com.techlingo.dtos.lesson.LessonDetailsDTO;

public record QuestionDetailsDTO(Long id, LessonDetailsDTO lesson, String description, Integer index) {
}
