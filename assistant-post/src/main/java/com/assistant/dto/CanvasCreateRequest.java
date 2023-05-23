package com.assistant.dto;

import java.util.List;

public final class CanvasCreateRequest {
    private final Long canvasId;

    private final Long postId;

    private final List<ShapeCreateRequest> shapeCreateRequests;

    public CanvasCreateRequest(Long postId, List<ShapeCreateRequest> shapeCreateRequests) {
        this.canvasId = null;
        this.postId = postId;
        this.shapeCreateRequests = shapeCreateRequests;
    }

    public static CanvasCreateRequest create(Long postId, List<ShapeCreateRequest> shapeCreateRequests) {
        return new CanvasCreateRequest(postId, shapeCreateRequests);
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
