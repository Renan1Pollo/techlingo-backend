package com.techlingo.domain.answer;

import com.techlingo.domain.question.Question;
import com.techlingo.dtos.answer.AnswerDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "answers")
@Table(name = "answers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "feedback_text", nullable = false, length = 500)
    private String feedbackText;

    @Column(name = "correct", nullable = false)
    private boolean correct;

    public Answer(AnswerDTO data) {
        this.question = data.question();
        this.text = data.text();
        this.correct = data.correct();;
        this.feedbackText = data.feedbackText();
    }

}
