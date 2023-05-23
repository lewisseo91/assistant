package com.assistant.service;

import com.assistant.domain.Shape;
import com.assistant.dto.PointCreateRequest;
import com.assistant.dto.ShapeCreateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("쉐입 서비스 테스트")
@DataJpaTest
@Import(ShapeService.class)
class ShapeServiceTest {
    @Autowired
    private ShapeService shapeService;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("쉐입을 생성할 수 있다.")
    @Test
    public void 쉐입은_생성된다() {
        Long shapeId = 1L;
        Long canvasId = 1L;
        String orientation = "portrait";
        String fontStyle = "italic";
        List<PointCreateRequest> pointCreateRequests = List.of();
        ShapeCreateRequest shapeCreateRequest = new ShapeCreateRequest(shapeId, canvasId, orientation, fontStyle, pointCreateRequests);
        Shape createdShape = shapeService.create(shapeCreateRequest);

        assertEquals(createdShape.getShapeId(), shapeId);
    }
}