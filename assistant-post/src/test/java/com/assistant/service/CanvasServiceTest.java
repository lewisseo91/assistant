package com.assistant.service;

import com.assistant.domain.Canvas;
import com.assistant.dto.CanvasCreateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
@Import(CanvasService.class)
class CanvasServiceTest {
    @Autowired
    private CanvasService canvasService;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void 캔버스는_하나의_포스트를_가지고_있다() {
        Long id = 1L;
        Long postId = 1L;
        CanvasCreateRequest canvasCreateRequest = new CanvasCreateRequest(id, postId);

        canvasService.create(canvasCreateRequest);

        assertEquals(canvasCreateRequest.getCanvasId(), id);
        assertNotEquals(canvasCreateRequest.getPostId(), null);
        assertEquals(canvasCreateRequest.getPostId(), postId);
    }
}