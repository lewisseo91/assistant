package com.assistant.domain;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private final Long canvasId;
    private final List<Long> shapes; // 임시
    private final List<Long> contents;


    public Canvas(Long canvasId) {
        this.canvasId = canvasId;
        this.shapes = new ArrayList<>();
        this.contents = new ArrayList<>();
    }// 임시

    public Canvas(Long canvasId, List<Long> shapes, List<Long> contents) {
        this.canvasId = canvasId;
        this.shapes = shapes;
        this.contents = contents;
    }

    public static Canvas create(Long id) {
        return new Canvas(id);
    }

    public Long getCanvasId() {
        return canvasId;
    }

    public static Canvas update(Long canvasId, List<Long> updateShapes, List<Long> updateContents) {
        return new Canvas(canvasId, updateShapes, updateContents);
    }

    public List<Long> getShapes() {
        return this.shapes;
    }

    public List<Long> getContents() {
        return contents;
    }
}
