package com.assistant.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("포스트 도메인 테스트")
public class PostTest {

    @DisplayName("포스트를 등록할 수 있다.")
    @Test
    public void 등록한다() {
        Long id = 1L;
        Long authorId = 1L;
        String title = "타이틀1";

        Post post = Post.create(id, authorId, title);

        assertEquals(title, post.getTitle());
    }

    @DisplayName("포스트를 수정할 수 있다.")
    @Test
    public void 수정한다() {
        Long id = 1L;
        Long authorId = 1L;
        String title = "타이틀1";
        Post post = new Post(id, authorId, title);

        String updatedTitle = "수정된 타이틀";
        Post updatedPost = new Post(id, authorId, updatedTitle);
        post.update(updatedPost);

        assertEquals(updatedTitle, updatedPost.getTitle());
    }
}
