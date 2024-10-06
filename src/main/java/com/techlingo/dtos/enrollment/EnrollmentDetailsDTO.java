package com.techlingo.dtos.enrollment;

import com.techlingo.domain.user.User;
import com.techlingo.dtos.course.CourseDetailsDTO;

import java.time.LocalDateTime;

public record EnrollmentDetailsDTO(Long id, User user, CourseDetailsDTO course, LocalDateTime enrollmentDate,
                                   Integer currentLesson, Integer currentUnit) {
}
