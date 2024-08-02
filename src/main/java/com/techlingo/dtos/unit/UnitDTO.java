package com.techlingo.dtos;

import com.techlingo.domain.course.Course;

public record UnitDTO(Course course, String title, String description, Double points, Integer index) {
}
