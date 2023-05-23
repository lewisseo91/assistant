package com.assistant.handler;

import com.assistant.domain.Post;
import com.assistant.dto.PostCreateRequest;
import com.assistant.dto.ShapeCreateRequest;
import com.assistant.event.CanvasCreateEvent;
import com.assistant.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.event.RecordApplicationEvents;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RecordApplicationEvents
class CanvasEventHandlerTest {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private PostService postService;

    @Test
    public void 등록한다() {
        Long authorId = 1L;
        String title_1 = "포스트1";
        List<ShapeCreateRequest> shapes =  new ArrayList<>();

        PostCreateRequest 글_1번_요청 = new PostCreateRequest(1L, authorId, title_1, shapes);
        Post savedPost = postService.savePost(글_1번_요청);

        assertEquals(savedPost.getPostId(), 글_1번_요청.getId());
    }

    @Test
    public void 캔버스_생성_이벤트() {
        CanvasCreateEvent canvasCreateEvent = new CanvasCreateEvent(null, List.of());
        applicationEventPublisher.publishEvent(canvasCreateEvent);
    }

}