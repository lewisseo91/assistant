package com.assistant.handler;

import com.assistant.event.CanvasCreateEvent;
import com.assistant.event.ShapeCreateEvent;
import com.assistant.service.CanvasService;
import com.assistant.service.ShapeService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ShapeEventHandler {
    private final ShapeService shapeService;

    public ShapeEventHandler(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @EventListener
    public void onCreateShapeRequest(ShapeCreateEvent shapeCreateEvent) {
        System.out.println("create Shape Event");
        shapeService.create(shapeCreateEvent.toRequest());
    }
}
