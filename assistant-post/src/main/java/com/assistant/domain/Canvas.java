package com.assistant.domain;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private final Long canvasId;

    private final Long postId;

    private final List<Long> shapes; // 임시
    private final List<Long> contents;


    public Canvas(Long canvasId, Long postId) {
        this.canvasId = canvasId;
        this.postId = postId;
        this.shapes = new ArrayList<>();
        this.contents = new ArrayList<>();
    }// 임시

    public Canvas(Long canvasId, Long postId, List<Long> shapes, List<Long> contents) {
        this.canvasId = canvasId;
        this.postId = postId;
        this.shapes = shapes;
        this.contents = contents;
    }

    public static Canvas create(Long id, Long postId) {
        return new Canvas(id, postId);
    }

    public static Canvas create(Long id, Long postId, List<Long> shapes) {
        return new Canvas(id, postId, shapes, new ArrayList<>());
    }

    public static Canvas update(Long canvasId, Long postId, List<Long> updateShapes, List<Long> updateContents) {
        return new Canvas(canvasId, postId, updateShapes, updateContents);
    }

    public void deleteShape(Long shapeId) {
        this.shapes.remove(shapeId);
    }

    public Long getCanvasId() {
        return canvasId;
    }

    public Long getPostId() {
        return postId;
    }

    public List<Long> getShapes() {
        return this.shapes;
    }

    public List<Long> getContents() {
        return contents;
    }
}
