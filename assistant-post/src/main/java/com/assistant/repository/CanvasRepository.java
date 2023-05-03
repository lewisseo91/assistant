package com.assistant.repository;

import com.assistant.domain.Canvas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CanvasRepository extends JpaRepository<Canvas, Long> {
}
