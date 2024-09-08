package com.assistant.handler;

import com.assistant.event.ShapeCreateEvent;
import com.assistant.event.ShapeStyleCreateEvent;
import com.assistant.service.ShapeStyleService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ShapeStyleEventHandler {
    private final ShapeStyleService shapeStyleService;

    public ShapeStyleEventHandler(ShapeStyleService shapeStyleService) {
        this.shapeStyleService = shapeStyleService;
    }

    @EventListener
    public void onCreateShapeStyleRequest(ShapeStyleCreateEvent shapeStyleCreateEvent) {
        System.out.println("create Shape Style Event");
        shapeStyleService.create(shapeStyleCreateEvent.toRequest());
    }
}
