package com.techlingo.dtos.enrollment;

import com.techlingo.domain.user.User;
import com.techlingo.dtos.course.CourseResponseDTO;

import java.time.LocalDateTime;

public record EnrollmentResponseDTO(Long id, User user, CourseResponseDTO course, LocalDateTime enrollmentDate,
                                    Integer currentLesson) {
}
