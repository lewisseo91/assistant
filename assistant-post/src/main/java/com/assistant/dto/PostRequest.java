package com.assistant.dto;

import com.assistant.domain.Post;

public final class PostRequest {
    private final Long id;
    private final Long authorId;
    private final String title;

    public PostRequest(Long id, Long authorId, String title) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
    }

    public final Post to() {
        return Post.create(id, authorId, title);
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
