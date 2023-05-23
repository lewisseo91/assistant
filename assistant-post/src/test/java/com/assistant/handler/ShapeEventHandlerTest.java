package com.assistant.handler;

import com.assistant.dto.PointCreateRequest;
import com.assistant.event.CanvasCreateEvent;
import com.assistant.event.ShapeCreateEvent;
import com.assistant.service.ShapeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.event.RecordApplicationEvents;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("쉐입 이벤트 테스트")
@SpringBootTest
@RecordApplicationEvents
class ShapeEventHandlerTest {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @MockBean
    private ShapeService shapeService;

    @DisplayName("쉐입 생성 이벤트 테스트")
    @Test
    public void 쉐입_생성_이벤트_테스트() {
        Long shapeId = 1L;
        Long canvasId = 1L;
        String orientation = "portrait";
        String fontStyle = "normal";
        List<PointCreateRequest> pointCreateRequests = List.of();
        ShapeCreateEvent shapeCreateEvent = new ShapeCreateEvent(shapeId, canvasId, orientation, fontStyle, pointCreateRequests);
        applicationEventPublisher.publishEvent(shapeCreateEvent);

        verify(shapeService, times(1))
                .create(any());
    }
}