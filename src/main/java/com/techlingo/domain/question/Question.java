package com.techlingo.domain.question;

import com.techlingo.domain.answer.Answer;
import com.techlingo.domain.lesson.Lesson;
import com.techlingo.dtos.question.QuestionDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "questions")
@Table(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "`index`", nullable = false)
    private Integer index;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;

    public Question(QuestionDTO data) {
        this.lesson = data.lesson();
        this.description = data.description();
        this.index = data.index();
    }

    public List<Answer> getAnswers() {
        if (this.answers == null) {
            this.answers = new ArrayList<>(); // Garante que não seja nulo
        }
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers != null ? answers : new ArrayList<>(); // Evita nulo
    }
}
