package com.techlingo.controllers;

import com.techlingo.domain.content.Content;
import com.techlingo.dtos.content.ContentDTO;
import com.techlingo.dtos.content.ContentDetailsDTO;
import com.techlingo.dtos.content.ContentResponseDTO;
import com.techlingo.dtos.lesson.LessonDetailsDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        List<ContentResponseDTO> contents = this.contentService.getAllContentDTOs();
        return new ResponseEntity<>(contents, HttpStatus.OK);
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<?> findContentById(@PathVariable Long contentId) throws Exception {
        Optional<Content> contentOptional = this.contentService.findContentById(contentId);

        if (contentOptional.isEmpty()) {
           return ResponseEntity.status(404).body("Conteudo not found");
        }

        ContentDetailsDTO contentDetails = this.entityMappingService.mapToContentDetailsDTO(contentOptional.get());

        return new ResponseEntity<>(contentDetails, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContentDetailsDTO>> getAllCourseDetails() {
        List<ContentDetailsDTO> contents = this.contentService.getAllContentDetails();
        return new ResponseEntity<>(contents, HttpStatus.OK);
    }
}
