package com.assistant.dto;

public final class CanvasCreateRequest {
    private final Long postId;

    public CanvasCreateRequest(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }
}
