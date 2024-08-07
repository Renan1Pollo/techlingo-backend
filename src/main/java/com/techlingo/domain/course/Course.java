package com.techlingo.domain.course;

import com.techlingo.domain.unit.Unit;
import com.techlingo.dtos.course.CourseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "courses")
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false, length = 500)
    private String image;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Unit> units;

    public Course(CourseDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.image = data.image();
    }

}

