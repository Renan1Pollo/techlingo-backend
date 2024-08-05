package com.techlingo.services;

import com.techlingo.domain.lesson.Lesson;
import com.techlingo.domain.unit.Unit;
import com.techlingo.dtos.lesson.LessonDTO;
import com.techlingo.dtos.lesson.LessonResponseDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonService {

    @Autowired
    private LessonRepository repository;

    @Autowired
    private UnitService unitService;

    @Autowired
    private EntityMappingService entityMappingService;

    public Lesson createLesson(LessonDTO data) {
        Lesson newLesson = new Lesson(data);
        repository.save(newLesson);
        return newLesson;
    }

    public Boolean updateLesson(Long id, LessonDTO data) {
        Optional<Lesson> unitOptional = this.repository.findLessonById(id);

        if (unitOptional.isPresent()) {
            Lesson existingLesson = unitOptional.get();
            existingLesson = new Lesson(data);
            existingLesson.setId(id);
            repository.save(existingLesson);
            return true;
        }

        return false;
    }

    public Boolean deleteLessonById(Long id) {
        Optional<Lesson> lessonOptional = this.repository.findLessonById(id);

        if (lessonOptional.isPresent()) {
            Lesson lesson = lessonOptional.get();
            repository.deleteById(lesson.getId());
            return true;
        }

        return false;
    }

    public List<LessonResponseDTO> getAllLessonDTOs() {
        List<Lesson> lessons = getAllLessons();
        return lessons.stream()
                .map(entityMappingService::mapToLessonResponseDTO)
                .collect(Collectors.toList());
    }

    public List<Lesson> getAllLessons() {
        return this.repository.findAll();
    }

    public Lesson findLessonById(Long id) throws Exception {
        return this.repository.findLessonById(id).orElseThrow(() -> new Exception("Licao não encontrada"));
    }

    public Lesson findLessonByUnit(Unit unit) throws Exception {
        return this.repository.findLessonByUnit(unit).orElseThrow(() -> new Exception("Licao não encontrada"));
    }

    public Unit searchUnitByTitle(String title) throws Exception {
        return this.unitService.findUnitByTitle(title);
    }
}
