package com.techlingo.dtos.content;

import com.techlingo.domain.lesson.Lesson;

public record ContentDTO(Lesson lesson, String title, String text, String image, Integer index) {
}
