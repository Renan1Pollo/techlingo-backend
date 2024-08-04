package com.techlingo.dtos.unit;

import com.techlingo.domain.course.Course;

public record UnitDTO(Course course, String title, String description, Double points, Integer index) {
}
