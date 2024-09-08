package com.assistant.handler;

import com.assistant.event.PointCreateEvent;
import com.assistant.service.PointService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.event.RecordApplicationEvents;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("포인트 이벤트 테스트")
@SpringBootTest
@RecordApplicationEvents
class PointEventHandlerTest {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @MockBean
    private PointService pointService;

    @DisplayName("포인트 생성 이벤트 테스트")
    @Test
    public void 포인트_생성_이벤트_테스트() {

        Long pointId = 1L;
        Long shapeId = 1L;
        Long x = 123L;
        Long y = 234L;
        Long z = 0L;
        PointCreateEvent pointCreateEvent = new PointCreateEvent(pointId, shapeId, x, y, z);
        applicationEventPublisher.publishEvent(pointCreateEvent);

        verify(pointService, times(1))
                .create(any());
    }
}