package com.techlingo.repositories;

import com.techlingo.domain.enrollment.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Optional<Enrollment> findEnrollmentById(Long id);

    Optional<List<Enrollment>> findEnrollmentByUserId(Long id);
}
