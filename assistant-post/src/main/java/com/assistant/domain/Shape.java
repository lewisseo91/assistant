package com.assistant.domain;

import java.util.ArrayList;
import java.util.List;

public class Shape {
    private final Long shapeId;
    private final List<Long> points; // 임시

    public Shape(Long shapeId, List<Long> points) {
        this.shapeId = shapeId;
        this.points = points;
    }

    public static Shape create(Long id, List<Long> points) {
        return new Shape(id, points);
    }

    public Long getShapeId() {
        return this.shapeId;
    }
}
