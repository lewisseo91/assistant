package com.assistant.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private final Long pointId;

    @Column(name = "shape_id")
    private final Long shapeId;

    @Column(name = "x")
    private final Long x;

    @Column(name = "y")
    private final Long y;

    @Column(name = "z")
    private final Long z;

    public Point(Long pointId, Long shapeId, Long x, Long y, Long z) {
        this.pointId = pointId;
        this.shapeId = shapeId;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point() {
        this.pointId = null;
        this.shapeId = null;
        this.x = null;
        this.y = null;
        this.z = null;
    }

    public static Point create(Long pointId, Long shapeId, Long x, Long y, Long z) {
        return new Point(pointId, shapeId, x, y, z);
    }

    public Long getPointId() {
        return pointId;
    }

    public Long getShapeId() {
        return shapeId;
    }

    public Long getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    public Long getZ() {
        return z;
    }

}
