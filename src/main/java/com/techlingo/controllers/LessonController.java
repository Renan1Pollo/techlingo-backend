package com.techlingo.controllers;

import com.techlingo.domain.lesson.Lesson;
import com.techlingo.dtos.LessonDTO;
import com.techlingo.services.LessonService;
import com.techlingo.services.UnitService;
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

    @Autowired
    private UnitService unitService;

    @PostMapping
    public ResponseEntity<Lesson> createLesson(@RequestBody LessonDTO lessonDTO) {
        lessonService.createLesson(lessonDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{unitId}")
    public ResponseEntity<?> updateLesson(@PathVariable Long lessonId, @RequestBody LessonDTO lessonDTO) {
        Boolean isUpdated = this.lessonService.updateLesson(lessonId, lessonDTO);
        return isUpdated ? new ResponseEntity<>(HttpStatus.OK) : ResponseEntity.status(404).body("Licao not found");
    }

    @DeleteMapping("/{unitId}")
    public ResponseEntity<?> deleteLessonById(@PathVariable Long lessonId) {
        Boolean isDeleted = this.lessonService.deleteLessonById(lessonId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(404).body("Licao not found");
    }

    @GetMapping
    public ResponseEntity<List<Lesson>> getAllLessons() {
        List<Lesson> lessons = this.lessonService.getAllLessons();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }
}
