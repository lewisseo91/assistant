package com.assistant.service;

import com.assistant.domain.Canvas;
import com.assistant.event.CanvasCreateEvent;
import com.assistant.dto.ShapeCreateRequest;
import com.assistant.repository.CanvasRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CanvasService {
    private final CanvasRepository canvasRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public CanvasService(CanvasRepository canvasRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.canvasRepository = canvasRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void create(CanvasCreateEvent canvasCreateEvent) {
        Canvas canvas = Canvas.create(canvasCreateEvent.getCanvasId(), canvasCreateEvent.getPostId());
        Canvas savedCanvas = canvasRepository.save(canvas);

        this.sendShapeCreateRequest(canvasCreateEvent, savedCanvas);
    }

    private void sendShapeCreateRequest(CanvasCreateEvent canvasCreateEvent, Canvas savedCanvas) {
        canvasCreateEvent.getShapeCreateRequests()
                .forEach(shapeCreateRequest -> {
                    ShapeCreateRequest updatedCreateRequest = shapeCreateRequest.update(savedCanvas.getCanvasId(), shapeCreateRequest);
                    applicationEventPublisher.publishEvent(updatedCreateRequest);
                });
    }
}
