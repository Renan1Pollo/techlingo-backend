package com.techlingo.services;

import com.techlingo.domain.course.Course;
import com.techlingo.domain.unit.Unit;
import com.techlingo.dtos.unit.UnitDTO;
import com.techlingo.dtos.unit.UnitDetailsDTO;
import com.techlingo.dtos.unit.UnitResponseDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnitService {

    @Autowired
    private UnitRepository repository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EntityMappingService entityMappingService;


    public Unit createUnit(UnitDTO data) {
        Unit newUnit = new Unit(data);
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
            unit.getLessons().clear();
            repository.deleteById(unit.getId());
            return true;
        }

        return false;
    }

    public List<UnitResponseDTO> getAllUnitDTOs() {
        List<Unit> units = getAllUnits();
        return units.stream()
                .map(entityMappingService::mapToUnitResponseDTO)
                .collect(Collectors.toList());
    }

    public List<UnitDetailsDTO> getAllUnitDetails() {
        List<Unit> units = getAllUnits();
        return units.stream()
                .map(entityMappingService::mapToUnitDetailsDTO)
                .collect(Collectors.toList());
    }

    public List<Unit> getAllUnits() {
        return this.repository.findAll();
    }

    public Unit findUnitById(Long id) throws Exception {
        return this.repository.findUnitById(id).orElseThrow(() -> new Exception("Unidade não encontrada"));
    }

    public List<Unit> findUnitByCourse(Course course) throws Exception {
        Optional<List<Unit>> optionalUnitList = this.repository.findUnitByCourse(course);

        if (optionalUnitList.isPresent()) {
            List<Unit> unitList = optionalUnitList.get();
            return unitList;
        }

        return new ArrayList<>();
    }

    public Unit findUnitByTitle(String title) throws Exception {
        return this.repository.findUnitByTitle(title).orElseThrow(() -> new Exception("Unidade não encontrada"));
    }

    public Course searchCourseByName(String name) throws Exception {
        return this.courseService.findCourseByName(name);
    }

}
