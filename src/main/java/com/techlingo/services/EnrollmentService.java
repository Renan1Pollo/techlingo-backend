package com.techlingo.services;

import com.techlingo.domain.enrollment.Enrollment;
import com.techlingo.dtos.enrollment.EnrollmentDTO;
import com.techlingo.dtos.enrollment.EnrollmentDetailsDTO;
import com.techlingo.dtos.enrollment.EnrollmentResponseDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository repository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private EntityMappingService entityMappingService;

    public Enrollment registerForCourse(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = new Enrollment(enrollmentDTO);
        return repository.save(enrollment);
    }

    public List<EnrollmentResponseDTO> getAllEnrollmentResponses() {
        return getAllEnrollments().stream()
                .map(entityMappingService::mapToEnrollmentResponseDTO)
                .collect(Collectors.toList());
    }

    public List<EnrollmentDetailsDTO> getAllEnrollmentDetails() {
        return getAllEnrollments().stream()
                .map(entityMappingService::mapToEnrollmentDetailsDTO)
                .collect(Collectors.toList());
    }

    public List<EnrollmentResponseDTO> getEnrollmentsByUserId(Long userId) {
        return findEnrollmentsByUserId(userId)
                .orElse(List.of())
                .stream()
                .map(entityMappingService::mapToEnrollmentResponseDTO)
                .collect(Collectors.toList());
    }

    public List<Enrollment> getAllEnrollments() {
        return repository.findAll();
    }

    public Optional<List<Enrollment>> findEnrollmentsByUserId(Long userId) {
        return repository.findEnrollmentByUserId(userId);
    }

    public Optional<Enrollment> findEnrollmentByUserAndCourse(Long userId, Long courseId) {
        return repository.findEnrollmentByUserIdAndCourseId(userId, courseId);
    }

    public Optional<Enrollment> findEnrollmentById(Long id) {
        return repository.findEnrollmentById(id);
    }


}
