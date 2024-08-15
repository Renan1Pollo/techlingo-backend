package com.techlingo.dtos.lesson;

import com.techlingo.dtos.unit.UnitDetailsDTO;

public record LessonDetailsDTO(Long id, UnitDetailsDTO unit, String title, String description, Double points,
                               Integer index) {
}
