package com.techlingo.services;

import com.techlingo.domain.course.Course;
import com.techlingo.dtos.CourseDTO;
import com.techlingo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public Course createCourse(CourseDTO data) {
        Course newCourse = new Course(data);
        repository.save(newCourse);
        return newCourse;
    }

    public Boolean updateCourse(Long id, CourseDTO data) {
        Optional<Course> coursesOptional = this.repository.findCourseById(id);

        if (coursesOptional.isPresent()) {
            Course existingCourse = coursesOptional.get();
            existingCourse = new Course(data);
            existingCourse.setId(id);
            repository.save(existingCourse);
            return true;
        }

        return false;
    }

    public Boolean deleteCourseById(Long id) {
        Optional<Course> coursesOptional = this.repository.findCourseById(id);

        if (coursesOptional.isPresent()) {
            Course course = coursesOptional.get();
            repository.deleteById(course.getId());
            return true;
        }

        return false;
    }

    public List<Course> getAllCourses() {
        return this.repository.findAll();
    }

    public Course findCourseById(Long id) throws Exception {
        return this.repository.findCourseById(id).orElseThrow(() -> new Exception("Curso não encontrado"));
    }

    public Course findCourseByName(String name) throws Exception {
        return this.repository.findCourseByName(name).orElseThrow(() -> new Exception("Curso não encontrado"));
    }
}
