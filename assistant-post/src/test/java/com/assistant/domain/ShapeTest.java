package com.assistant.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("쉐입 도메인 테스트")
class ShapeTest {

    @DisplayName(value = "쉐입 등록 (캔버스 등록 후)")
    @Test
    public void 쉐입을_등록할수_있다_1() {
        Long canvasId = 1L;
        Long shapeId = 1L;
        Shape shape = Shape.create(shapeId, canvasId);

        assertEquals(shape.getShapeId(), 1);
    }

    @DisplayName(value = "쉐입이 생성될 때 스타일이 생성된다 (쉐입 등록과 동시에)")
    @Test
    public void 쉐입을_생성될때_스타일이_생성된다() {
        Long canvasId = 1L;
        Long shapeId = 1L;
        Long styleId = 1L;
        Shape shape = Shape.create(shapeId, canvasId);
        ShapeStyle style = ShapeStyle.create(styleId, shapeId, "portrait", "normal");

        assertEquals(shape.getShapeId(), 1L);
        assertEquals(style.getStyleId(), 1L);
    }

}