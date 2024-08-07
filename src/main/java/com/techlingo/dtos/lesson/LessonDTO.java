package com.techlingo.dtos.lesson;

import com.techlingo.domain.unit.Unit;

public record LessonDTO(Unit unit, String title, String description, Double points, Integer index) {
}