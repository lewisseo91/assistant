package com.assistant.service;

import com.assistant.domain.Point;
import com.assistant.dto.PointCreateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("포인트 서비스 테스트")
@DataJpaTest
@Import(PointService.class)
class PointServiceTest {
    @Autowired
    private PointService pointService;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("포인트를 생성할 수 있다")
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