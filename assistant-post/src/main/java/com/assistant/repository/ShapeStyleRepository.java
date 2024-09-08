package com.assistant.repository;

import com.assistant.domain.Shape;
import com.assistant.domain.ShapeStyle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShapeStyleRepository extends JpaRepository<ShapeStyle, Long> {
}
