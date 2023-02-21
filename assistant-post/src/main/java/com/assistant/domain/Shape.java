package com.assistant.domain;

import java.util.List;

public class Shape {
    private final Long shapeId;

    private final Long styleId;

    private final List<Long> points; // 임시

    public Shape(Long shapeId, Long styleId, List<Long> points) {
        this.shapeId = shapeId;
        this.styleId = styleId;
        this.points = points;
    }

    public static Shape create(Long id, Long styleId, List<Long> points) {
        return new Shape(id, styleId, points);
    }

    public Long getShapeId() {
        return this.shapeId;
    }

    public List<Long> getPoints() {
        return this.points;
    }

    public void delete() {
        this.points.clear();
    }

    public Long getStyleId() {
        return this.styleId;
    }
}
