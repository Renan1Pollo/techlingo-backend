package com.techlingo.services;

import com.techlingo.domain.course.Course;
import com.techlingo.domain.enrollment.Enrollment;
import com.techlingo.domain.lesson.Lesson;
import com.techlingo.domain.unit.Unit;
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
    private UnitService unitService;

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

    public Enrollment updateEnrollment(EnrollmentResponseDTO enrollmentResponseDTO, Integer currentUnit, Integer currentLesson) throws Exception {
        Enrollment enrollment = findEnrollmentById(enrollmentResponseDTO.id()).orElseThrow(() -> new Exception("Enrollment not found"));

        boolean isLessonAlreadyCompleted = enrollment.getCurrentLesson() > currentLesson && enrollment.getCurrentUnit() == currentUnit;
        if (isLessonAlreadyCompleted) {
            return enrollment;
        }

        List<Unit> units = enrollment.getCourse().getUnits();
        List<Lesson> lessons = units.get(currentUnit).getLessons();
        int totalLessons = lessons.size();

        boolean isLastLessonInUnit = currentLesson == --totalLessons;
        if (isLastLessonInUnit) {
            enrollment.setCurrentUnit(++currentUnit);
            enrollment.setCurrentLesson(0);
        } else {
            enrollment.setCurrentLesson(++currentLesson);
        }

        return repository.save(enrollment);
    }

    public byte[] generateUnitConclusionReport(EnrollmentResponseDTO enrollmentResponseDTO, Long unitId) throws Exception {
        Map<String, Object> reportParams = new HashMap<>();
        ClassLoader classLoader = getClass().getClassLoader();

        File reportFile = new File(Objects.requireNonNull(classLoader.getResource("reports/Unit_Completetion_Certificate.jrxml")).getFile());

        Enrollment enrollment = findEnrollmentById(enrollmentResponseDTO.id()).orElseThrow(() -> new IllegalArgumentException("Enrollment not found"));
        Unit unit = unitService.findUnitById(unitId);
        List<Lesson> lessons = unit.getLessons();
        int totalLessons = lessons.size();

        reportParams.put("userName", enrollment.getUser().getName());
        reportParams.put("courseName", enrollment.getCourse().getName());
        reportParams.put("unitTitle", unit.getTitle());
        reportParams.put("totalLessons", totalLessons);

        return ReportUtils.generatePdfReport(reportFile.getAbsolutePath(), reportParams);
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
