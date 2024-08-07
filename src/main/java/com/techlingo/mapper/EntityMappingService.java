package com.techlingo.mapper;

import com.techlingo.domain.course.Course;
import com.techlingo.domain.question.Question;
import com.techlingo.domain.unit.Unit;
import com.techlingo.domain.lesson.Lesson;
import com.techlingo.dtos.course.CourseResponseDTO;
import com.techlingo.dtos.question.QuestionResponseDTO;
import com.techlingo.dtos.unit.UnitResponseDTO;
import com.techlingo.dtos.lesson.LessonResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityMappingService {

    public CourseResponseDTO mapToCourseResponseDTO(Course course) {
        List<UnitResponseDTO> unitResponseDTOList = course.getUnits().stream()
                .map(this::mapToUnitResponseDTO)
                .collect(Collectors.toList());

        return new CourseResponseDTO(course.getId(), course.getName(), course.getDescription(), course.getImage(), unitResponseDTOList);
    }

    public UnitResponseDTO mapToUnitResponseDTO(Unit unit) {
        List<LessonResponseDTO> lessonResponseDTOList = unit.getLessons().stream()
                .map(this::mapToLessonResponseDTO)
                .collect(Collectors.toList());

        return new UnitResponseDTO(unit.getId(), unit.getTitle(), unit.getDescription(), unit.getPoints(), unit.getIndex(), lessonResponseDTOList);
    }

    public LessonResponseDTO mapToLessonResponseDTO(Lesson lesson) {
        List<QuestionResponseDTO> questionResponseDTOList = lesson.getQuestions().stream()
                .map(this::mapToQuestionResponseDTO)
                .collect(Collectors.toList());

        return new LessonResponseDTO(lesson.getId(), lesson.getTitle(), lesson.getDescription(), lesson.getPoints(), lesson.getIndex(), questionResponseDTOList);
    }

    public QuestionResponseDTO mapToQuestionResponseDTO(Question question) {
        return new QuestionResponseDTO(question.getId(), question.getDescription(), question.getIndex(), new ArrayList<>());
    }

}
