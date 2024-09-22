package com.techlingo.services;

import com.techlingo.domain.content.Content;
import com.techlingo.dtos.content.ContentDTO;
import com.techlingo.dtos.content.ContentDetailsDTO;
import com.techlingo.dtos.content.ContentResponseDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContentService {

    @Autowired
    private ContentRepository repository;

    @Autowired
    private EntityMappingService entityMappingService;

    public Content createContent(ContentDTO data) {
        Content newContent = new Content(data);
        repository.save(newContent);
        return newContent;
    }

    public Boolean updateContent(Long id, ContentDTO data) {
        Optional<Content> contentOptional = this.repository.findContentById(id);

        if (contentOptional.isPresent()) {
            Content existingContent = contentOptional.get();
            existingContent = new Content(data);
            existingContent.setId(id);
            repository.save(existingContent);
            return true;
        }

        return false;
    }

    public Boolean deleteContentById(Long id) {
        Optional<Content> contentOptional = this.repository.findContentById(id);

        if (contentOptional.isPresent()) {
            Content existingContent = contentOptional.get();
            repository.deleteById(existingContent.getId());
            return true;
        }

        return false;
    }

    public List<ContentResponseDTO> getAllContentDTOs() {
        List<Content> contents = getAllContents();
        return contents.stream()
                .map(entityMappingService::mapToContentResponseDTO)
                .collect(Collectors.toList());
    }

    public List<ContentDetailsDTO> getAllContentDetails() {
        List<Content> contents = getAllContents();
        return contents.stream()
                .map(entityMappingService::mapToContentDetailsDTO)
                .collect(Collectors.toList());
    }

    public List<Content> getAllContents() {
        return this.repository.findAll();
    }

    public Content findContentById(Long id) throws Exception {
        return this.repository.findContentById(id).orElseThrow(() -> new Exception("Conteudo não encontrado"));
    }

}
