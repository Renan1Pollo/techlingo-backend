package com.techlingo.repositories;

import com.techlingo.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findCourseById(Long id);

    Optional<Course> findCourseByName(String name);
}
