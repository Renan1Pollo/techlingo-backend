package com.techlingo.controllers;

import com.techlingo.domain.course.Course;
import com.techlingo.domain.unit.Unit;
import com.techlingo.dtos.unit.UnitDTO;
import com.techlingo.dtos.unit.UnitResponseDTO;
import com.techlingo.services.CourseService;
import com.techlingo.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UnitService unitService;

    @PostMapping
    public ResponseEntity<Unit> createUnit(@RequestBody UnitDTO unitDTO) {
        unitService.createUnit(unitDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{unitId}")
    public ResponseEntity<?> updateUnit(@PathVariable Long unitId, @RequestBody UnitDTO unitDTO) {
        Boolean isUpdated = this.unitService.updateUnit(unitId, unitDTO);
        return isUpdated ? new ResponseEntity<>(HttpStatus.OK) : ResponseEntity.status(404).body("Unidade not found");
    }

    @DeleteMapping("/{unitId}")
    public ResponseEntity<?> deleteUnitById(@PathVariable Long unitId) {
        Boolean isDeleted = this.unitService.deleteUnitById(unitId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(404).body("Unidade not found");
    }

    @GetMapping
    public ResponseEntity<List<UnitResponseDTO>> getAllUnits() {
        List<UnitResponseDTO> units = this.unitService.getAllUnitDTOs();
        return new ResponseEntity<>(units, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> findUnitByTitle(@RequestParam String title) {
        try {
            Unit unit = this.unitService.findUnitByTitle(title);
            return unit != null ? new ResponseEntity<>(unit, HttpStatus.OK) : ResponseEntity.status(404).body("Unidade not found");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchCourse")
    public ResponseEntity<?> findUnitByCourse(@RequestParam Long courseId) {
        try {
            Course course = this.courseService.findCourseById(courseId);
            List<Unit> unitList = this.unitService.findUnitByCourse(course);
            return !unitList.isEmpty() ? new ResponseEntity<>(unitList, HttpStatus.OK) : ResponseEntity.status(404).body("Unidade not found");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
