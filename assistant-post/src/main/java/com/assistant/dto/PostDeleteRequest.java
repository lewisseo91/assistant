package com.assistant.dto;

public final class PostDeleteRequest {
    private final Long id;

    public PostDeleteRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
