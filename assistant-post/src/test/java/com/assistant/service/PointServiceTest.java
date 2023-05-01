package com.assistant.service;

import com.assistant.domain.Point;
import com.assistant.domain.Shape;
import com.assistant.dto.PointCreateRequest;
import com.assistant.dto.ShapeCreateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(PointService.class)
class PointServiceTest {
    @Autowired
    private PointService pointService;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void 포인트는_생성된다() {
        Long shapeId = 1L;
        Long pointId = 1L;
        Long x = 12L;
        Long y = 23L;
        Long z = 5L;

        PointCreateRequest pointCreateRequest = new PointCreateRequest(pointId, shapeId, x, y, z);
        Point createdPoint = pointService.create(pointCreateRequest);

        assertEquals(createdPoint.getShapeId(), shapeId);
    }
}