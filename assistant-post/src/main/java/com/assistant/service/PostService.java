package com.assistant.service;

import com.assistant.domain.Post;
import com.assistant.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public void updatePost(Long id, Post updatePost) {
        Optional<Post> currentPost = postRepository.findById(id);
        currentPost.ifPresent(cPost -> cPost.update(updatePost));
    }

    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
