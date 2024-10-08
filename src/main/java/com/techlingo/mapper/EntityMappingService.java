package com.techlingo.mapper;

import com.techlingo.domain.answer.Answer;
import com.techlingo.domain.content.Content;
import com.techlingo.domain.course.Course;
import com.techlingo.domain.enrollment.Enrollment;
import com.techlingo.domain.lesson.Lesson;
import com.techlingo.domain.question.Question;
import com.techlingo.domain.unit.Unit;
import com.techlingo.dtos.answer.AnswerDetailsDTO;
import com.techlingo.dtos.answer.AnswerResponseDTO;
import com.techlingo.dtos.content.ContentDetailsDTO;
import com.techlingo.dtos.content.ContentResponseDTO;
import com.techlingo.dtos.course.CourseDetailsDTO;
import com.techlingo.dtos.course.CourseResponseDTO;
import com.techlingo.dtos.enrollment.EnrollmentDetailsDTO;
import com.techlingo.dtos.enrollment.EnrollmentResponseDTO;
import com.techlingo.dtos.lesson.LessonDetailsDTO;
import com.techlingo.dtos.lesson.LessonResponseDTO;
import com.techlingo.dtos.question.QuestionDetailsDTO;
import com.techlingo.dtos.question.QuestionResponseDTO;
import com.techlingo.dtos.unit.UnitDetailsDTO;
import com.techlingo.dtos.unit.UnitResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityMappingService {

    public EnrollmentResponseDTO mapToEnrollmentResponseDTO(Enrollment enrollment) {
        return new EnrollmentResponseDTO(enrollment.getId(), enrollment.getUser(), this.mapToCourseResponseDTO(enrollment.getCourse()), enrollment.getEnrollmentDate(), enrollment.getCurrentLesson(), enrollment.getCurrentUnit());
    }

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

        List<ContentResponseDTO> contentResponseDTOList = lesson.getContents().stream()
                .map(this::mapToContentResponseDTO)
                .collect(Collectors.toList());

        return new LessonResponseDTO(lesson.getId(), lesson.getTitle(), lesson.getDescription(),
                   lesson.getPoints(), lesson.getIndex(), contentResponseDTOList, questionResponseDTOList);
    }

    public ContentResponseDTO mapToContentResponseDTO(Content content) {
        return new ContentResponseDTO(content.getId(), content.getTitle(), content.getText(), content.getImage(), content.getIndex());
    }

    public QuestionResponseDTO mapToQuestionResponseDTO(Question question) {
        List<AnswerResponseDTO> answerResponseDTOList = question.getAnswers().stream()
                .map(this::mapToAnswerResponseDTO)
                .collect(Collectors.toList());

        return new QuestionResponseDTO(question.getId(), question.getDescription(), question.getIndex(), answerResponseDTOList);
    }

    public AnswerResponseDTO mapToAnswerResponseDTO(Answer answer) {
        return new AnswerResponseDTO(answer.getId(), answer.getText(), answer.getFeedbackText(), answer.isCorrect());
    }

    // Map To Details DTO

    public EnrollmentDetailsDTO mapToEnrollmentDetailsDTO(Enrollment enrollment) {
        return new EnrollmentDetailsDTO(enrollment.getId(), enrollment.getUser(), this.mapToCourseDetailsDTO(enrollment.getCourse()), enrollment.getEnrollmentDate(), enrollment.getCurrentLesson(), enrollment.getCurrentUnit());
    }

    public CourseDetailsDTO mapToCourseDetailsDTO(Course course) {
        return new CourseDetailsDTO(course.getId(), course.getName(), course.getDescription(), course.getImage());
    }

    public UnitDetailsDTO mapToUnitDetailsDTO(Unit unit) {
        return new UnitDetailsDTO(unit.getId(), this.mapToCourseDetailsDTO(unit.getCourse()), unit.getTitle(), unit.getDescription(), unit.getPoints(), unit.getIndex());
    }

    public LessonDetailsDTO mapToLessonDetailsDTO(Lesson lesson) {
        return new LessonDetailsDTO(lesson.getId(), this.mapToUnitDetailsDTO(lesson.getUnit()), lesson.getTitle(), lesson.getDescription(), lesson.getPoints(), lesson.getIndex());
    }

    public ContentDetailsDTO mapToContentDetailsDTO(Content content) {
        return new ContentDetailsDTO(content.getId(), mapToLessonDetailsDTO(content.getLesson()), content.getTitle(), content.getText(), content.getImage(), content.getIndex());
    }

    public QuestionDetailsDTO mapToQuestionDetailsDTO(Question question) {
        return new QuestionDetailsDTO(question.getId(), this.mapToLessonDetailsDTO(question.getLesson()), question.getDescription(), question.getIndex());
    }

    public AnswerDetailsDTO mapToAnswerDetailsDTO(Answer answer) {
        return new AnswerDetailsDTO(answer.getId(), answer.getText(), mapToQuestionDetailsDTO(answer.getQuestion()), answer.getFeedbackText(), answer.isCorrect());
    }

}
