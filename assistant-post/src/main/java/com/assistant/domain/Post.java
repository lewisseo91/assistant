package com.assistant.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private final Long postId;

    @Column(name = "author_id")
    private final Long authorId;

    @Column(name = "title")
    private final String title;

    public Post(Long postId, Long authorId, String title) {
        this.postId = postId;
        this.authorId = authorId;
        this.title = title;
    }

    public static Post create(Long id, Long authorId, String title) {
        return new Post(id, authorId, title);
    }

    public Post update(Long id, Long authorId, String title) {
        return new Post(id, authorId, title);
    }

    public Post update(Post updatePost) {
        return new Post(updatePost.postId, updatePost.authorId, updatePost.title);
    }

    public Long getPostId() {
        return postId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }
}
