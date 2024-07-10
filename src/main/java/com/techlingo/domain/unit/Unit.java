package com.techlingo.domain.unit;

import com.techlingo.domain.course.Course;
import com.techlingo.dtos.UnitDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "units")
@Table(name = "units")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "points", nullable = false)
    private Double points;

    @Column(name = "index", nullable = false)
    private Integer index;

    public Unit(UnitDTO data) {
        this.title = data.titulo();
        this.description = data.descricao();
        this.points = data.pontos();
        this.index = data.indice();
    }
}
