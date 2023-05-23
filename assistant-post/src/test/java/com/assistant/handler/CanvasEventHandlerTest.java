package com.assistant.handler;

import com.assistant.event.CanvasCreateEvent;
import com.assistant.service.CanvasService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.event.RecordApplicationEvents;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("캔버스 이벤트 테스트")
@SpringBootTest
@RecordApplicationEvents
class CanvasEventHandlerTest {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @MockBean
    private CanvasService canvasService;


    @DisplayName("캔버스 생성 이벤트 테스트")
    @Test
    public void 캔버스_생성_이벤트() {
        CanvasCreateEvent canvasCreateEvent = new CanvasCreateEvent(null, List.of());
        applicationEventPublisher.publishEvent(canvasCreateEvent);

        verify(canvasService, times(1))
                .create(any());
    }

}