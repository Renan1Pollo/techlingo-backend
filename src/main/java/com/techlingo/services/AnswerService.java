package com.techlingo.services;

import com.techlingo.domain.answer.Answer;
import com.techlingo.dtos.answer.AnswerDTO;
import com.techlingo.dtos.answer.AnswerDetailsDTO;
import com.techlingo.dtos.answer.AnswerResponseDTO;
import com.techlingo.mapper.EntityMappingService;
import com.techlingo.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository repository;

    @Autowired
    private EntityMappingService entityMappingService;

    public Answer createAnswer(AnswerDTO data) {
        Answer newAnswer = new Answer(data);
        repository.save(newAnswer);
        return newAnswer;
    }

    public Boolean updateAnswer(Long id, AnswerDTO data) {
        Optional<Answer> answerOptional = this.repository.findAnswerById(id);

        if (answerOptional.isPresent()) {
            Answer existingAnswer = answerOptional.get();
            existingAnswer = new Answer(data);
            existingAnswer.setId(id);
            repository.save(existingAnswer);
            return true;
        }

        return false;
    }

    public Boolean deleteAnswerById(Long id) {
        Optional<Answer> answerOptional = this.repository.findAnswerById(id);

        if (answerOptional.isPresent()) {
            Answer answer = answerOptional.get();
            repository.deleteById(answer.getId());
            return true;
        }

        return false;
    }

    public List<AnswerResponseDTO> getAllAnswerDTOs() {
        List<Answer> answers = getAllAnswers();
        return answers.stream()
                .map(entityMappingService::mapToAnswerResponseDTO)
                .collect(Collectors.toList());
    }

    public List<AnswerDetailsDTO> getAllAnswersDetails() {
        List<Answer> answers = getAllAnswers();
        return answers.stream()
                .map(entityMappingService::mapToAnswerDetailsDTO)
                .collect(Collectors.toList());
    }

    public List<Answer> getAllAnswers() {
        return this.repository.findAll();
    }

    public Answer findAnswerById(Long id) throws Exception {
        return this.repository.findAnswerById(id).orElseThrow(() -> new Exception("Resposta não encontrada"));
    }
}
