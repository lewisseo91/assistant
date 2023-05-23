package com.assistant.event;

import com.assistant.dto.PointCreateRequest;

import java.util.List;

public class ShapeCreateEvent {
    private final Long shapeId;

    private final Long canvasId;

    private final String orientation;

    private final String fontStyle;

    private final List<PointCreateRequest> pointCreateRequests;

    public ShapeCreateEvent(Long shapeId, Long canvasId, String orientation, String fontStyle, List<PointCreateRequest> pointCreateRequests) {
        this.shapeId = shapeId;
        this.canvasId = canvasId;
        this.orientation = orientation;
        this.fontStyle = fontStyle;
        this.pointCreateRequests = pointCreateRequests;
    }

    public Long getShapeId() {
        return shapeId;
    }

    public Long getCanvasId() {
        return canvasId;
    }

    public String getOrientation() {
        return orientation;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public List<PointCreateRequest> getPointCreateRequests() {
        return pointCreateRequests;
    }

    public ShapeCreateEvent update(Long canvasId, ShapeCreateEvent shapeCreateRequest) {
        return new ShapeCreateEvent(shapeCreateRequest.shapeId, canvasId, shapeCreateRequest.orientation, shapeCreateRequest.fontStyle, shapeCreateRequest.pointCreateRequests);
    }
}
