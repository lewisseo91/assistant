package com.assistant.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTest {

    @Test
    public void 등록한다() {
        Long id = 1L;
        Long authorId = 1L;
        String title = "타이틀1";

        Post post = Post.create(id, authorId, title);

        assertEquals(title, post.getTitle());
    }

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
