package com.assistant.controller;

import com.assistant.dto.PostCreateRequest;
import com.assistant.dto.PostUpdateRequest;
import com.assistant.service.PostService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/save")
    public Mono<Void> savePost(@RequestBody PostCreateRequest postCreateRequest) {
        return Mono.fromRunnable(() -> postService.savePost(postCreateRequest));
    }

    @PutMapping("/update")
    public Mono<Void> updatePost(@RequestBody PostUpdateRequest postUpdateRequest) {
        return Mono.fromRunnable(() -> postService.updatePost(postUpdateRequest.getId(), postUpdateRequest));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deletePost(@PathVariable Long id) {
        return Mono.fromRunnable(() -> postService.deletePost(id));
    }


}