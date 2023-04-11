package com.assistant.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Shape {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private final Long shapeId;

    @Column(name = "style_id")
    private final Long styleId;

    @Column(name = "canvas_id")
    private final Long canvasId;

    @Column(name = "deleted")
    private Boolean deleted;

    public Shape(Long shapeId, Long styleId, Long canvasId) {
        this.shapeId = shapeId;
        this.styleId = styleId;
        this.canvasId = canvasId;
        this.deleted = false;
    }

    public static Shape create(Long shapeId, Long styleId, Long canvasId) {
        return new Shape(shapeId, styleId, canvasId);
    }

    public void delete() {
        this.deleted = true;
    }

    public Long getShapeId() {
        return this.shapeId;
    }

    public Long getCanvasId() {
        return canvasId;
    }

    public Long getStyleId() {
        return this.styleId;
    }
}
