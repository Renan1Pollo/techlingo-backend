package com.techlingo.repositories;

import com.techlingo.domain.content.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {

    Optional<Content> findContentById(Long id);
}
