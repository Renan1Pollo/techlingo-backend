package com.techlingo.dtos.enrollment;

import com.techlingo.domain.course.Course;
import com.techlingo.domain.user.User;

public record EnrollmentDTO(User user, Course course) { }
