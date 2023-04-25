package com.assistant.dto;

public class ShapeCreateRequest {
    private final Long canvasId;

    public ShapeCreateRequest(Long canvasId) {
        this.canvasId = canvasId;
    }

    public Long getCanvasId() {
        return canvasId;
    }
}
