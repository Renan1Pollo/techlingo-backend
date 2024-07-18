package com.techlingo.services;

import com.techlingo.domain.course.Course;
import com.techlingo.domain.unit.Unit;
import com.techlingo.dtos.UnitDTO;
import com.techlingo.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {

    @Autowired
    private UnitRepository repository;

    @Autowired
    private CourseService courseService;

    public Unit createUnit(UnitDTO data) {
        Unit newUnit = new Unit(data);

        try {
            Course course = searchCourseByName(data.curso());
            newUnit.setCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
        }

        repository.save(newUnit);
        return newUnit;
    }

    public Boolean updateUnit(Long id, UnitDTO data) {
        Optional<Unit> unitOptional = this.repository.findUnitById(id);

        if (unitOptional.isPresent()) {
            Unit existingUnit = unitOptional.get();
            existingUnit = new Unit(data);
            existingUnit.setId(id);
            repository.save(existingUnit);
            return true;
        }

        return false;
    }

    public Boolean deleteUnitById(Long id) {
        Optional<Unit> unitOptional = this.repository.findUnitById(id);

        if (unitOptional.isPresent()) {
            Unit unit = unitOptional.get();
            repository.deleteById(unit.getId());
            return true;
        }

        return false;
    }

    public List<Unit> getAllUnits() {
        return this.repository.findAll();
    }

    public Unit findUnitById(Long id) throws Exception {
        return this.repository.findUnitById(id).orElseThrow(() -> new Exception("Unidade não encontrada"));
    }

    public Unit findUnitByCourse(Course course) throws Exception {
        return this.repository.findUnitByCourse(course).orElseThrow(() -> new Exception("Unidade não encontrada"));
    }

    public Unit findUnitByTitle(String title) throws Exception {
        return this.repository.findUnitByTitle(title).orElseThrow(() -> new Exception("Unidade não encontrada"));
    }

    public Course searchCourseByName(String name) throws Exception {
        return this.courseService.findCourseByName(name);
    }

}
