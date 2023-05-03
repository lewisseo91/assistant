package com.assistant.service;

import com.assistant.domain.Post;
import com.assistant.dto.PostCreateRequest;
import com.assistant.dto.PostDeleteRequest;
import com.assistant.dto.PostUpdateRequest;
import com.assistant.dto.ShapeCreateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
@Import(PostService.class)
class PostServiceTest {
    @Autowired
    private PostService postService;

    private final Long postId = 1L;
    private PostCreateRequest 글_1번_요청;
    private PostUpdateRequest 수정글_1번;
    private PostDeleteRequest 글_1번_삭제_요청;

    @BeforeEach
    void setUp() {
        Long authorId = 1L;
        String title_1 = "포스트1";
        String title_2 = "포스트2";
        List<ShapeCreateRequest> shapes =  new ArrayList<>();

        글_1번_요청 = new PostCreateRequest(postId, authorId, title_1, shapes);
        수정글_1번 = new PostUpdateRequest(postId, authorId, title_2, shapes);
        글_1번_삭제_요청 = new PostDeleteRequest(postId);
    }

    @Test
    public void 등록한다() {
        Post savedPost = postService.savePost(글_1번_요청);

        assertEquals(savedPost.getPostId(), 글_1번_요청.getId());
    }

    @Test
    @DisplayName("포스트는 하나 이상의 캔버스를 포함한다.")
    public void 포스트를_등록하면_하나_이상의_캔버스를_포함한다() {
//        postService.savePost(글_1번);
    }

    @Test
    public void 수정한다() {
        postService.updatePost(postId, 수정글_1번);
    }

    @Test
    public void 삭제한다() {
        postService.savePost(글_1번_요청);

        //when
        postService.deletePost(글_1번_삭제_요청);
    }

    @Test
    public void 삭제한다_2() {
        postService.savePost(글_1번_요청);

        //when
        postService.deletePost(글_1번_요청.getId());
    }
}