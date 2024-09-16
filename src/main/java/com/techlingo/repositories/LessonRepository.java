package com.techlingo.repositories;

import com.techlingo.domain.lesson.Lesson;
import com.techlingo.domain.unit.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    Optional<Lesson> findLessonById(Long id);

    Optional<Lesson> findLessonByUnit(Unit unit);
}

