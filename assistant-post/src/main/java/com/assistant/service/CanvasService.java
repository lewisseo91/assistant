package com.assistant.service;

import com.assistant.domain.Canvas;
import com.assistant.domain.Post;
import com.assistant.dto.CanvasCreateRequest;
import com.assistant.dto.PostCreateRequest;
import com.assistant.dto.PostDeleteRequest;
import com.assistant.dto.PostUpdateRequest;
import com.assistant.repository.CanvasRepository;
import com.assistant.repository.PostRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CanvasService {
    private final CanvasRepository canvasRepository;

    public CanvasService(CanvasRepository canvasRepository) {
        this.canvasRepository = canvasRepository;
    }

    public void create(CanvasCreateRequest canvasCreateRequest) {
        Canvas canvas = Canvas.create(canvasCreateRequest.getCanvasId(), canvasCreateRequest.getPostId());
        canvasRepository.save(canvas);
    }
}
