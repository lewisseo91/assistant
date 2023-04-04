package com.assistant.dto;

public final class PostCreateRequest {
    private final Long id;
    private final Long authorId;
    private final String title;

    public PostCreateRequest(Long id, Long authorId, String title) {
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
