package com.assistant.event;

import com.assistant.dto.ShapeCreateRequest;

import java.util.List;

public final class CanvasCreateEvent {
    private final Long canvasId;

    private final Long postId;

    private final List<ShapeCreateRequest> shapeCreateRequests;

    public CanvasCreateEvent(Long postId, List<ShapeCreateRequest> shapeCreateRequests) {
        this.canvasId = null;
        this.postId = postId;
        this.shapeCreateRequests = shapeCreateRequests;
    }

    public List<ShapeCreateRequest> getShapeCreateRequests() {
        return shapeCreateRequests;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getCanvasId() {
        return canvasId;
    }
}
