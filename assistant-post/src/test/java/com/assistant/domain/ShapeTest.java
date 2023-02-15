package com.assistant.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @DisplayName(value = "쉐입 등록 (캔버스 등록 후)")
    @Test
    public void 쉐입을_등록할수_있다_1() {
        Long shapeId = 1L;
        List<Long> points = List.of(1L, 2L);
        Shape shape = Shape.create(shapeId, points);

        Long canvasId = 1L;
        Canvas canvas = Canvas.create(canvasId);

        Canvas updatedCanvas = Canvas.update(canvas.getCanvasId(), List.of(shape.getShapeId()), canvas.getContents());
        assertEquals(updatedCanvas.getShapes().size(), 1);
    }

    @DisplayName(value = "쉐입 등록 (캔버스 등록과 동시에)")
    @Test
    public void 쉐입을_등록할수_있다_2() {
        Long shapeId = 1L;
        List<Long> points = List.of(1L, 2L);
        Shape shape = Shape.create(shapeId, points);

        Long canvasId = 1L;
        Canvas canvas = Canvas.create(canvasId, List.of(shape.getShapeId()));

        assertEquals(canvas.getShapes().size(), 1);
    }

    @DisplayName(value = "쉐입 삭제")
    @Test
    public void 쉐입을_삭제할수_있다_1() {
        Long shapeId = 1L;
        List<Long> points = List.of(1L, 2L);
        Shape shape = Shape.create(shapeId, points);

        Long canvasId = 1L;
        List<Long> shapes = new ArrayList<>();
        shapes.add(shape.getShapeId());
        Canvas canvas = Canvas.create(canvasId, shapes);

        canvas.deleteShape(shape.getShapeId());
        assertEquals(canvas.getShapes().size(), 0);
    }


}