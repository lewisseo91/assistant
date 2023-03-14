package com.assistant.service;

import com.assistant.domain.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(PostService.class)
class PostServiceTest {
    @Autowired
    private PostService postService;

    private final Long postId = 1L;
    private Post 글_1번;
    private Post 수정글_1번;

    @BeforeEach
    void setUp() {
        Long authorId = 1L;
        String title_1 = "포스트1";
        String title_2 = "포스트2";

        글_1번 = new Post(postId, authorId, title_1);
        수정글_1번 = new Post(postId, authorId, title_2);
    }

    @Test
    public void 등록한다() {
        postService.savePost(글_1번);
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
        //when
        postService.deletePost(글_1번);
    }

    @Test
    public void 삭제한다_2() {
        postService.savePost(글_1번);

        //when
        postService.deletePost(글_1번.getPostId());
    }
}