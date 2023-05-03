package com.assistant.service;

import com.assistant.domain.Shape;
import com.assistant.dto.PointCreateRequest;
import com.assistant.dto.ShapeCreateRequest;
import com.assistant.repository.ShapeRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShapeService {
    private final ShapeRepository shapeRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public ShapeService(ShapeRepository shapeRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.shapeRepository = shapeRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Shape create(ShapeCreateRequest shapeCreateRequest) {
        Shape shape = Shape.create(shapeCreateRequest.getShapeId(), shapeCreateRequest.getCanvasId());
        Shape savedShape = shapeRepository.save(shape);

        this.sendPointCreateRequest(shapeCreateRequest, savedShape);

        return savedShape;
    }

    private void sendPointCreateRequest(ShapeCreateRequest shapeCreateRequest, Shape savedShape) {
        shapeCreateRequest.getPointCreateRequests()
                .forEach(pointCreateRequest -> {
                    PointCreateRequest createRequest = pointCreateRequest.update(savedShape.getShapeId(), pointCreateRequest);
                    applicationEventPublisher.publishEvent(createRequest);
                });
    }


}
