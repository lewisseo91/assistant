package com.assistant.service;

import com.assistant.domain.Canvas;
import com.assistant.dto.CanvasCreateRequest;
import com.assistant.repository.CanvasRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CanvasService {
    private final CanvasRepository canvasRepository;

    public CanvasService(CanvasRepository canvasRepository) {
        this.canvasRepository = canvasRepository;
    }

    public void create(CanvasCreateRequest canvasCreateRequest) {
        Canvas canvas = Canvas.create(getNextId(), canvasCreateRequest.getPostId());
        canvasRepository.save(canvas);
    }

    public Long getNextId() {
        return canvasRepository.getNextId();
    }
}
