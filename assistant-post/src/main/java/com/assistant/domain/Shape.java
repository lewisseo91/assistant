package com.assistant.domain;

import java.util.List;

public class Shape {
    private final Long shapeId;

    private final Long styleId;

    private final List<Long> points; // 임시

    private final Long canvasId;

    public Shape(Long canvasId, Long shapeId, Long styleId, List<Long> points) {
        this.canvasId = canvasId;
        this.shapeId = shapeId;
        this.styleId = styleId;
        this.points = points;
    }

    public static Shape create(Long canvasId, Long shapeId, Long styleId, List<Long> points) {
        return new Shape(canvasId, shapeId, styleId, points);
    }

    public Long getShapeId() {
        return this.shapeId;
    }

    public Long getCanvasId() {
        return canvasId;
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
