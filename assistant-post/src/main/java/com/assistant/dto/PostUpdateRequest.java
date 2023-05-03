package com.assistant.dto;

import java.util.List;

public final class PostUpdateRequest {
    private final Long id;

    private final Long authorId;
    private final String title;
    private final List<ShapeCreateRequest> shapeCreateRequests;

    public PostUpdateRequest(Long id, Long authorId, String title, List<ShapeCreateRequest> shapeCreateRequests) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.shapeCreateRequests = shapeCreateRequests;
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

    public List<ShapeCreateRequest> getShapeCreateRequests() {
        return shapeCreateRequests;
    }
}
