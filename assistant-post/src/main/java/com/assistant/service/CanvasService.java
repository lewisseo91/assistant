package com.assistant.service;

import com.assistant.domain.Canvas;
import com.assistant.dto.CanvasCreateRequest;
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

    public void create(CanvasCreateRequest canvasCreateRequest) {
        Canvas canvas = Canvas.create(canvasCreateRequest.getCanvasId(), canvasCreateRequest.getPostId());
        Canvas savedCanvas = canvasRepository.save(canvas);

        this.sendShapeCreateRequest(canvasCreateRequest, savedCanvas);
    }

    private void sendShapeCreateRequest(CanvasCreateRequest canvasCreateEvent, Canvas savedCanvas) {
        canvasCreateEvent.getShapeCreateRequests()
                .forEach(shapeCreateRequest -> {
                    ShapeCreateRequest updatedCreateRequest = shapeCreateRequest.update(savedCanvas.getCanvasId(), shapeCreateRequest);
                    applicationEventPublisher.publishEvent(updatedCreateRequest);
                });
    }
}
