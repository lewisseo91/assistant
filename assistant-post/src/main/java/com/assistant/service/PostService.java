package com.assistant.service;

import com.assistant.domain.Post;
import com.assistant.dto.CanvasCreateRequest;
import com.assistant.dto.PostCreateRequest;
import com.assistant.dto.PostDeleteRequest;
import com.assistant.dto.PostUpdateRequest;
import com.assistant.repository.PostRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public PostService(PostRepository postRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.postRepository = postRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void savePost(PostCreateRequest postCreateRequest) {
        Post post = Post.create(postCreateRequest.getId(), postCreateRequest.getAuthorId(), postCreateRequest.getTitle());
        Post savedPost = postRepository.save(post);

        this.sendCanvasCreateRequest(postCreateRequest, savedPost);
    }

    private void sendCanvasCreateRequest(PostCreateRequest postCreateRequest, Post savedPost) {
        CanvasCreateRequest canvasCreateRequest = new CanvasCreateRequest(savedPost.getPostId(), postCreateRequest.getShapeCreateRequests());
        applicationEventPublisher.publishEvent(canvasCreateRequest);
    }

    public void updatePost(Long id, PostUpdateRequest updatePostRequest) {
        Optional<Post> currentPost = postRepository.findById(id);
        currentPost.ifPresent(cPost -> cPost.update(updatePostRequest.getId(), updatePostRequest.getAuthorId(), updatePostRequest.getTitle()));
    }

    public void deletePost(PostDeleteRequest postDeleteRequest) {
        postRepository.deleteById(postDeleteRequest.getId());
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
