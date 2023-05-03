package com.assistant.repository;

import com.assistant.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PointRepository extends JpaRepository<Point, Long> {
}
