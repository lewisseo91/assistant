package com.assistant.dto;

import java.util.List;

public final class CanvasCreateRequest {
    private final Long canvasId;
    private final Long postId;

    public CanvasCreateRequest(Long canvasId, Long postId) {
        this.canvasId = canvasId;
        this.postId = postId;
    }

    public Long getCanvasId() {
        return canvasId;
    }

    public Long getPostId() {
        return postId;
    }
}
