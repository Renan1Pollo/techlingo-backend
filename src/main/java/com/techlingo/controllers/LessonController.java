package com.techlingo.controllers;

import com.techlingo.domain.lesson.Lesson;
import com.techlingo.dtos.lesson.LessonDTO;
import com.techlingo.dtos.lesson.LessonDetailsDTO;
import com.techlingo.dtos.lesson.LessonResponseDTO;
import com.techlingo.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping
    public ResponseEntity<Lesson> createLesson(@RequestBody LessonDTO lessonDTO) {
        lessonService.createLesson(lessonDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{lessonId}")
    public ResponseEntity<?> updateLesson(@PathVariable Long lessonId, @RequestBody LessonDTO lessonDTO) {
        Boolean isUpdated = this.lessonService.updateLesson(lessonId, lessonDTO);
        return isUpdated ? new ResponseEntity<>(HttpStatus.OK) : ResponseEntity.status(404).body("Lesson not found");
    }

    @DeleteMapping("/{lessonId}")
    public ResponseEntity<?> deleteLessonById(@PathVariable Long lessonId) {
        Boolean isDeleted = this.lessonService.deleteLessonById(lessonId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(404).body("Lesson not found");
    }

    @GetMapping
    public ResponseEntity<List<LessonResponseDTO>> getAllLessons() {
        List<LessonResponseDTO> lessons = this.lessonService.getAllLessonDTOs();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LessonDetailsDTO>> getAllLessonDetailsDTOs() {
        List<LessonDetailsDTO> lessons = this.lessonService.getAllLessonDetailsDTOs();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }
}
