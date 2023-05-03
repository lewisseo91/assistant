package com.assistant.repository;

import com.assistant.domain.Shape;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShapeRepository extends JpaRepository<Shape, Long> {
}
