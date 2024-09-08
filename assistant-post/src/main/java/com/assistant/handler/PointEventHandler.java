package com.assistant.handler;

import com.assistant.event.PointCreateEvent;
import com.assistant.event.ShapeCreateEvent;
import com.assistant.service.PointService;
import com.assistant.service.ShapeService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PointEventHandler {
    private final PointService pointService;

    public PointEventHandler(PointService pointService) {
        this.pointService = pointService;
    }

    @EventListener
    public void onCreatePointRequest(PointCreateEvent pointCreateEvent) {
        System.out.println("create Point Event");
        pointService.create(pointCreateEvent.toRequest());
    }
}
