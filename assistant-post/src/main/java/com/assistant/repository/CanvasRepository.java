package com.assistant.repository;

import com.assistant.domain.Canvas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CanvasRepository extends JpaRepository<Canvas, Long> {

    @Query(value = "SELECT AUTO_INCREMENT " +
            "FROM information_schema.TABLES " +
            "WHERE TABLE_SCHEMA = DATABASE() " +
            "AND TABLE_NAME = 'canvas'", nativeQuery = true)
    Long getNextId();
}
