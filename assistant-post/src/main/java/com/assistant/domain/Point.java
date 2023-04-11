package com.assistant.domain;

public class Point {
    private final Long pointId;

    private final Long shapeId;

    private final Long x;

    private final Long y;

    private final Long z;

    public Point(Long pointId, Long shapeId, Long x, Long y, Long z) {
        this.pointId = pointId;
        this.shapeId = shapeId;
        this.x = x;
        this.y = y;
        this.z = z;
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
