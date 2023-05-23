package com.assistant.service;

import com.assistant.dto.CanvasCreateRequest;
import com.assistant.event.CanvasCreateEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

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
        Long postId = 1L;
        CanvasCreateRequest canvasCreateRequest = new CanvasCreateRequest(postId, List.of());

        canvasService.create(canvasCreateRequest);

        assertNotEquals(canvasCreateRequest.getPostId(), null);
        assertEquals(canvasCreateRequest.getPostId(), postId);
    }
}