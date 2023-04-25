package com.assistant.dto;

public final class CanvasCreateRequest {
    private final Long canvasId;
    private final Long postId;

    public CanvasCreateRequest(Long canvasId, Long postId) {
        this.canvasId = canvasId;
        this.postId = postId;
    }

    public CanvasCreateRequest(Long postId) {
        this.canvasId = null;
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getCanvasId() {
        return canvasId;
    }
}
