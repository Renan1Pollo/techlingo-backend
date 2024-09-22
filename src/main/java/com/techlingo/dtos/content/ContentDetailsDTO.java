package com.techlingo.dtos.content;

import com.techlingo.dtos.lesson.LessonDetailsDTO;

public record ContentDetailsDTO(Long id, LessonDetailsDTO lesson, String title, String text, String image,
                                Integer index) {
}
