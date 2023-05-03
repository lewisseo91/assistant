package com.assistant.service;

import com.assistant.domain.Point;
import com.assistant.domain.Shape;
import com.assistant.dto.PointCreateRequest;
import com.assistant.dto.ShapeCreateRequest;
import com.assistant.repository.PointRepository;
import com.assistant.repository.ShapeRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PointService {
    private final PointRepository pointRepository;

    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public Point create(PointCreateRequest pointCreateRequest) {
        Point point = Point.create(pointCreateRequest.getPointId(), pointCreateRequest.getShapeId(), pointCreateRequest.getX(), pointCreateRequest.getY(), pointCreateRequest.getZ());

        return pointRepository.save(point);
    }
}
