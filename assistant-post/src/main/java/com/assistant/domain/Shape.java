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

    @Column(name = "canvas_id")
    private final Long canvasId;

    @Column(name = "deleted")
    private Boolean deleted;

    public Shape(Long shapeId, Long canvasId) {
        this.shapeId = shapeId;
        this.canvasId = canvasId;
        this.deleted = false;
    }

    public Shape() {
        this.shapeId = null;
        this.canvasId = null;
        this.deleted = false;
    }

    public static Shape create(Long shapeId, Long canvasId) {
        return new Shape(shapeId, canvasId);
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
}
