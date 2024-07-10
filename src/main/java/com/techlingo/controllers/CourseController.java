package com.techlingo.controllers;

import com.techlingo.domain.course.Course;
import com.techlingo.dtos.CourseDTO;
import com.techlingo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

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
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = this.courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

}
