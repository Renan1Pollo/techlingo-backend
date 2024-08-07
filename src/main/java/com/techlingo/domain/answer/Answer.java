package com.techlingo.domain.answer;

import com.techlingo.domain.question.Question;
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

    @Column(name = "feedback_text", nullable = false)
    private String feedbackText;

    @Column(name = "correct", nullable = false)
    private boolean correct;

}
