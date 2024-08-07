package com.techlingo.dtos.question;

import com.techlingo.domain.lesson.Lesson;

public record QuestionDTO(Lesson lesson, String description, Integer index) {
}
