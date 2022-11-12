package com.assistant.domain;

public class Post {
    private final Long postId;
    private final Long authorId;
    private final String title;

    public Post(Long postId, Long authorId, String title) {
        this.postId = postId;
        this.authorId = authorId;
        this.title = title;
    }

    public static Post create(Long id, Long authorId, String title) {
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
