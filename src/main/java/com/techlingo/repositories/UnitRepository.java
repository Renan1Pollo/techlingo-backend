package com.techlingo.repositories;

import com.techlingo.domain.course.Course;
import com.techlingo.domain.unit.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    Optional<Unit> findUnitById(Long id);
    Optional<Unit> findUnitByTitle(String title);
    Optional<Unit> findUnitByCourse(Course course);
}
