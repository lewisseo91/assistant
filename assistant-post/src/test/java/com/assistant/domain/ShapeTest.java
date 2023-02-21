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
        Long styleId = 1L;
        List<Long> points = List.of(1L, 2L);
        Shape shape = Shape.create(shapeId, styleId, points);

        Long canvasId = 1L;
        Canvas canvas = Canvas.create(canvasId);

        Canvas updatedCanvas = Canvas.update(canvas.getCanvasId(), List.of(shape.getShapeId()), canvas.getContents());
        assertEquals(updatedCanvas.getShapes().size(), 1);
    }

    @DisplayName(value = "쉐입 등록 (캔버스 등록과 동시에)")
    @Test
    public void 쉐입을_등록할수_있다_2() {
        Long shapeId = 1L;
        Long styleId = 1L;
        List<Long> points = List.of(1L, 2L);
        Shape shape = Shape.create(shapeId, styleId, points);

        Long canvasId = 1L;
        Canvas canvas = Canvas.create(canvasId, List.of(shape.getShapeId()));

        assertEquals(canvas.getShapes().size(), 1);
    }

    @DisplayName(value = "쉐입 삭제")
    @Test
    public void 쉐입을_삭제할수_있다_1() {
        Long shapeId = 1L;
        Long styleId = 1L;
        List<Long> points = List.of(1L, 2L);
        Shape shape = Shape.create(shapeId, styleId, points);

        Long canvasId = 1L;
        List<Long> shapes = new ArrayList<>();
        shapes.add(shape.getShapeId());
        Canvas canvas = Canvas.create(canvasId, shapes);

        canvas.deleteShape(shape.getShapeId());
        assertEquals(canvas.getShapes().size(), 0);
    }

    @DisplayName(value = "쉐입이 생성될 때 포인트가 생성된다 (쉐입 등록과 동시에)")
    @Test
    public void 쉐입을_생성될때_포인트가_생성된다() {
        Long shapeId = 1L;
        Long styleId = 1L;
        Point point1 = Point.create(1L, 0L, 100L);
        Point point2 = Point.create(2L, 1L, 100L);
        List<Long> points = List.of(point1.getPointId(), point2.getPointId());
        Shape shape = Shape.create(shapeId, styleId, points);

        assertEquals(shape.getPoints().size(), 2);
    }

    @DisplayName(value = "쉐입이 삭제될 때 포인트도 삭제된다")
    @Test
    public void 쉐입을_생성될때_포인트가_삭제된다() {
        Long shapeId = 1L;
        Long styleId = 1L;
        List<Long> points = new ArrayList<>();
        Point point1 = Point.create(1L, 0L, 100L);
        Point point2 = Point.create(2L, 1L, 100L);
        points.add(point1.getPointId());
        points.add(point2.getPointId());
        Shape shape = Shape.create(shapeId, styleId, points);

        Long canvasId = 1L;
        List<Long> shapes = new ArrayList<>();
        shapes.add(shape.getShapeId());
        Canvas canvas = Canvas.create(canvasId, shapes);

        canvas.deleteShape(shape.getShapeId());
        shape.delete(); // 나중에 간접 연결 구조라면 id로 조회 후 삭제 필요
        assertEquals(shape.getPoints().size(), 0);
    }

    @DisplayName(value = "쉐입이 생성될 때 스타일이 생성된다 (쉐입 등록과 동시에)")
    @Test
    public void 쉐입을_생성될때_스타일이_생성된다() {
        Long shapeId = 1L;
        Long styleId = 1L;
        ShapeStyle style = ShapeStyle.create(styleId, "portrait", "normal");
        Point point1 = Point.create(1L, 0L, 100L);
        Point point2 = Point.create(2L, 1L, 100L);
        List<Long> points = List.of(point1.getPointId(), point2.getPointId());
        Shape shape = Shape.create(shapeId, style.getStyleId(), points);

        assertEquals(shape.getStyleId(), 1L);
    }

    @DisplayName(value = "쉐입이 삭제될 때 스타일이 삭제된다")
    @Test
    public void 쉐입을_생성될때_스타일이_삭제된다() {
        Long shapeId = 1L;
        Long styleId = 1L;
        ShapeStyle style = ShapeStyle.create(styleId, "portrait", "normal");

        List<Long> points = new ArrayList<>();
        Point point1 = Point.create(1L, 0L, 100L);
        Point point2 = Point.create(2L, 1L, 100L);
        points.add(point1.getPointId());
        points.add(point2.getPointId());

        Shape shape = Shape.create(shapeId, styleId, points);

        Long canvasId = 1L;
        List<Long> shapes = new ArrayList<>();
        shapes.add(shape.getShapeId());
        Canvas canvas = Canvas.create(canvasId, shapes);

        canvas.deleteShape(shape.getShapeId());
        shape.delete(); // 나중에 간접 연결 구조라면 id로 조회 후 삭제 필요
        style.delete();

        assertTrue(style.getDeleted());
    }

}