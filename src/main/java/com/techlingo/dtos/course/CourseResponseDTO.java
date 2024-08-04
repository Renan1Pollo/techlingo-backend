package com.techlingo.dtos.course;

import com.techlingo.dtos.unit.UnitResponseDTO;

import java.util.List;

public record CourseResponseDTO(Long id, String name, String description, String image, List<UnitResponseDTO> unitList) {
}
