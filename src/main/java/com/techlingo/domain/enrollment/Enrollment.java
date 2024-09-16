package com.techlingo.domain.enrollment;

import com.techlingo.domain.course.Course;
import com.techlingo.domain.user.User;
import com.techlingo.dtos.enrollment.EnrollmentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "enrollments")
@Table(name = "enrollments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "enrollment_date", nullable = false)
    private LocalDateTime enrollmentDate;

    @Column(name = "current_lesson", nullable = false)
    private int currentLesson;

    public Enrollment(EnrollmentDTO data) {
        this.user = data.user();
        this.course = data.course();
        this.enrollmentDate = LocalDateTime.now();
        this.currentLesson = 0;
    }

}
