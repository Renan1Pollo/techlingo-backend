package com.techlingo.controllers;

import com.techlingo.domain.enrollment.Enrollment;
import com.techlingo.dtos.enrollment.EnrollmentDTO;
import com.techlingo.dtos.enrollment.EnrollmentDetailsDTO;
import com.techlingo.dtos.enrollment.EnrollmentResponseDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.services.EnrollmentService;
import com.techlingo.utils.ReportUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private EntityMappingService entityMappingService;

    @PostMapping
    public ResponseEntity<?> registerForCourse(@RequestBody EnrollmentDTO enrollmentDTO) throws Exception {
        Enrollment enrollment = enrollmentService.registerForCourse(enrollmentDTO);
        return ResponseEntity.ok(entityMappingService.mapToEnrollmentResponseDTO(enrollment));
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDTO>> getAllEnrollmentResponses() {
        List<EnrollmentResponseDTO> enrollments = enrollmentService.getAllEnrollmentResponses();
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/generate-report")
    public ResponseEntity<byte[]> generateUnitConclusionReport() {
        return ReportUtils.buildReportResponse(enrollmentService.generateUnitConclusionReport());
    }

    @GetMapping("/details")
    public ResponseEntity<List<EnrollmentDetailsDTO>> getAllEnrollmentDetails() {
        List<EnrollmentDetailsDTO> enrollmentDetails = enrollmentService.getAllEnrollmentDetails();
        return ResponseEntity.ok(enrollmentDetails);
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<EnrollmentResponseDTO>> getEnrollmentsByUserId(@PathVariable Long userId) {
        List<EnrollmentResponseDTO> userEnrollments = enrollmentService.getEnrollmentsByUserId(userId);
        return ResponseEntity.ok(userEnrollments);
    }

    @GetMapping("/byUserAndCourse")
    public ResponseEntity<?> getEnrollmentByUserAndCourse(@RequestParam Long userId, @RequestParam Long courseId) {
        Optional<Enrollment> enrollmentOptional = enrollmentService.findEnrollmentByUserAndCourse(userId, courseId);

        if (enrollmentOptional.isPresent()) {
            EnrollmentResponseDTO enrollment = entityMappingService.mapToEnrollmentResponseDTO(enrollmentOptional.get());
            return ResponseEntity.ok(enrollment);
        }

       return ResponseEntity.noContent().build();
    }

}
