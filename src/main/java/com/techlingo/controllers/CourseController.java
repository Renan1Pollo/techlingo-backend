package com.techlingo.controllers;

import com.techlingo.domain.course.Course;
import com.techlingo.dtos.course.CourseDTO;
import com.techlingo.dtos.course.CourseDetailsDTO;
import com.techlingo.dtos.course.CourseResponseDTO;
import com.techlingo.dtos.unit.UnitDetailsDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private EntityMappingService entityMappingService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseDTO courseDTO) {
        courseService.createCourse(courseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO) {
        Boolean isUpdated = this.courseService.updateCourse(courseId, courseDTO);
        return isUpdated ? new ResponseEntity<>(HttpStatus.OK) : ResponseEntity.status(404).body("Curso not found");
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Long courseId) {
        Boolean isDeleted = this.courseService.deleteCourseById(courseId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(404).body("Curso not found");
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses() {
        List<CourseResponseDTO> courses = this.courseService.getAllCourseDTOs();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseDetailsDTO>> getAllCourseDetails() {
        List<CourseDetailsDTO> courses = this.courseService.getAllCourseDetails();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> findCourseById(@PathVariable Long courseId) {
        try {
            Course course = courseService.findCourseById(courseId);
            return ResponseEntity.ok(entityMappingService.mapToCourseDetailsDTO(course));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course Not Found");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> findCourseByName(@RequestParam String name) {
        try {
            Course course = courseService.findCourseByName(name);
            return ResponseEntity.ok(entityMappingService.mapToCourseDetailsDTO(course));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course Not Found");
        }
    }

}
