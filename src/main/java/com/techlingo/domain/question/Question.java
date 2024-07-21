package com.techlingo.domain.question;

import com.techlingo.domain.lesson.Lesson;
import com.techlingo.domain.unit.Unit;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "index", nullable = false)
    private Integer index;
}
