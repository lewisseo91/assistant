package com.assistant.repository;

import com.assistant.domain.Canvas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CanvasRepository extends JpaRepository<Canvas, Long> {
}
