package com.techlingo.controllers;

import com.techlingo.domain.content.Content;
import com.techlingo.domain.course.Course;
import com.techlingo.dtos.content.ContentDTO;
import com.techlingo.dtos.content.ContentDetailsDTO;
import com.techlingo.dtos.content.ContentResponseDTO;
import com.techlingo.dtos.course.CourseDTO;
import com.techlingo.dtos.course.CourseDetailsDTO;
import com.techlingo.dtos.course.CourseResponseDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.services.ContentService;
import com.techlingo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private EntityMappingService entityMappingService;

    @PostMapping
    public ResponseEntity<Content> createContent(@RequestBody ContentDTO contentDTO) {
        contentService.createContent(contentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{contentId}")
    public ResponseEntity<?> updateContent(@PathVariable Long contentId, @RequestBody ContentDTO contentDTO) {
        Boolean isUpdated = this.contentService.updateContent(contentId, contentDTO);
        return isUpdated ? new ResponseEntity<>(HttpStatus.OK) : ResponseEntity.status(404).body("Conteudo not found");
    }

    @DeleteMapping("/{contentId}")
    public ResponseEntity<?> deleteContentById(@PathVariable Long contentId) {
        Boolean isDeleted = this.contentService.deleteContentById(contentId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(404).body("Conteudo not found");
    }

    @GetMapping
    public ResponseEntity<List<ContentResponseDTO>> getAllContentDTOs() {
        List<ContentResponseDTO> courses = this.contentService.getAllContentDTOs();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContentDetailsDTO>> getAllCourseDetails() {
        List<ContentDetailsDTO> courses = this.contentService.getAllContentDetails();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
