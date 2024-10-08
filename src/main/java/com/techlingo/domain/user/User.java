package com.techlingo.domain.user;

import com.techlingo.dtos.auth.RegisterRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_access_date")
    private LocalDateTime lastAccessDate;

    @Column(name = "score", nullable = false)
    private BigDecimal score;

    @Column(name = "lives", nullable = false)
    private Integer lives;

    @Column(name = "user_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public User(RegisterRequestDTO data, Boolean isAdmin) {
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
        this.creationDate = LocalDateTime.now();
        this.lastAccessDate = LocalDateTime.now();
        this.score = BigDecimal.ZERO;
        this.lives = 5;
        this.userRole = isAdmin ? UserRole.ADMIN : UserRole.USER;
    }
}
