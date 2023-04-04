package com.assistant.dto;

public final class PostUpdateRequest {
    private final Long id;

    private final Long authorId;
    private final String title;

    public PostUpdateRequest(Long id, Long authorId, String title) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }
}
