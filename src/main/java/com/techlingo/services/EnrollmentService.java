package com.techlingo.services;

import com.techlingo.domain.course.Course;
import com.techlingo.domain.enrollment.Enrollment;
import com.techlingo.dtos.enrollment.EnrollmentDTO;
import com.techlingo.dtos.enrollment.EnrollmentDetailsDTO;
import com.techlingo.dtos.enrollment.EnrollmentResponseDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.repositories.EnrollmentRepository;
import com.techlingo.utils.ReportUtils;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
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

    public Enrollment registerForCourse(EnrollmentDTO enrollmentDTO) throws Exception {
        Course course = courseService.findCourseById(enrollmentDTO.course().getId());

        Enrollment enrollment = new Enrollment(enrollmentDTO);
        enrollment.setCourse(course);
        return repository.save(enrollment);
    }

    public byte[] generateUnitConclusionReport(){
        Map<String, Object> parametros = new HashMap<>();
        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(Objects.requireNonNull(classLoader.getResource("reports/Unit_Completetion_Certificate.jrxml")).getFile());

        byte[] bytes = ReportUtils.generatePdfReport(file.getAbsolutePath(), parametros);

        return bytes;
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
