package com.assistant.handler;

import com.assistant.event.ShapeStyleCreateEvent;
import com.assistant.service.ShapeStyleService;
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

@DisplayName("쉐입 스타일 이벤트 테스트")
@SpringBootTest
@RecordApplicationEvents
class ShapeStyleEventHandlerTest {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @MockBean
    private ShapeStyleService shapeStyleService;

    @DisplayName("쉐입 스타일 생성 이벤트 테스트")
    @Test
    public void 쉐입_스타일_생성_이벤트_테스트() {
        Long styleId = 1L;
        Long shapeId = 1L;
        String orientation = "portrait";
        String fontStyle = "normal";
        ShapeStyleCreateEvent shapeStyleCreateEvent = new ShapeStyleCreateEvent(styleId, shapeId, orientation, fontStyle);
        applicationEventPublisher.publishEvent(shapeStyleCreateEvent);

        verify(shapeStyleService, times(1))
                .create(any());
    }
}