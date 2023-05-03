package com.assistant.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Canvas {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private final Long canvasId;

    @Column(name = "post_id")
    private final Long postId;

    public Canvas() {
        this.canvasId = null;
        this.postId = null;
    }

    public Canvas(Long canvasId, Long postId) {
        this.canvasId = canvasId;
        this.postId = postId;
    }

    public static Canvas create(Long id, Long postId) {
        return new Canvas(id, postId);
    }

    public static Canvas update(Long canvasId, Long postId) {
        return new Canvas(canvasId, postId);
    }
    public Long getCanvasId() {
        return canvasId;
    }

    public Long getPostId() {
        return postId;
    }

}
