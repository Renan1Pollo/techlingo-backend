package com.techlingo.controllers;

import com.techlingo.dtos.enrollment.EnrollmentDTO;
import com.techlingo.dtos.enrollment.EnrollmentDetailsDTO;
import com.techlingo.dtos.enrollment.EnrollmentResponseDTO;
import com.techlingo.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<Void> registerForCourse(@RequestBody EnrollmentDTO enrollmentDTO) {
        enrollmentService.registerForCourse(enrollmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDTO>> getAllEnrollmentResponses() {
        List<EnrollmentResponseDTO> enrollments = enrollmentService.getAllEnrollmentResponses();
        return ResponseEntity.ok(enrollments);
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

}
