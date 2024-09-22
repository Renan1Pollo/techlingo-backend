package com.techlingo.domain.lesson;

import com.techlingo.domain.content.Content;
import com.techlingo.domain.question.Question;
import com.techlingo.domain.unit.Unit;
import com.techlingo.dtos.lesson.LessonDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "lessons")
@Table(name = "lessons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "points", nullable = false)
    private Double points;

    @Column(name = "`index`", nullable = false)
    private Integer index;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Question> questions;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Content> contents;

    public Lesson(LessonDTO data) {
        this.title = data.title();
        this.unit = data.unit();
        this.description = data.description();
        this.points = data.points();
        this.index = data.index();
    }
}
