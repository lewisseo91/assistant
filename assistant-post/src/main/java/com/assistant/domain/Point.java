package com.assistant.domain;

public class Point {
    private final Long pointId;
    private final Long x;
    private final Long y;

    public Point(Long pointId, Long x, Long y) {
        this.pointId = pointId;
        this.x = x;
        this.y = y;
    }

    public static Point create(Long id, Long x, Long y) {
        return new Point(id, x, y);
    }

    public Long getPointId() {
        return pointId;
    }
}
