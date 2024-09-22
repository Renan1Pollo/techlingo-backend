package com.techlingo.domain.content;

import com.techlingo.domain.lesson.Lesson;
import com.techlingo.dtos.content.ContentDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "contents")
@Table(name = "contents")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "text", nullable = false, columnDefinition = "LONGTEXT")
    private String text;

    @Column(name = "image", nullable = true, columnDefinition = "LONGTEXT")
    private String image;

    @Column(name = "`index`", nullable = false)
    private Integer index;

    public Content(ContentDTO data) {
        this.lesson = data.lesson();
        this.title = data.title();
        this.text = data.text();
        this.image = data.image();
        this.index = data.index();
    }
}
