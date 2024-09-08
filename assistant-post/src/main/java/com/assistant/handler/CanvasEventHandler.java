package com.assistant.handler;

import com.assistant.event.CanvasCreateEvent;
import com.assistant.service.CanvasService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CanvasEventHandler {
    private final CanvasService canvasService;

    public CanvasEventHandler(CanvasService canvasService) {
        this.canvasService = canvasService;
    }

    @EventListener
    public void onCreateCanvasRequest(CanvasCreateEvent canvasCreateEvent) {
        System.out.println("Create Canvas Event");
        canvasService.create(canvasCreateEvent.toRequest());
    }
}
