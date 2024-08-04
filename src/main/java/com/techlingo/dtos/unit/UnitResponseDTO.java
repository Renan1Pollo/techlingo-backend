package com.techlingo.dtos.unit;

import com.techlingo.dtos.lesson.LessonResponseDTO;

import java.util.List;

public record UnitResponseDTO(Long id, String title, String description, Double points, Integer index, List<LessonResponseDTO> lessonList) {
}
