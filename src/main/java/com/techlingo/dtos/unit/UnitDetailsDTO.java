package com.techlingo.dtos.unit;

import com.techlingo.dtos.course.CourseDetailsDTO;

public record UnitDetailsDTO(Long id, CourseDetailsDTO course, String title, String description, Double points, Integer index) {
}
