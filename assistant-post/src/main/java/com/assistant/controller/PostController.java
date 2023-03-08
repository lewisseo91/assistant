package com.assistant.controller;

import com.assistant.dto.PostRequest;
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
    public Mono<Void> savePost(@RequestBody PostRequest postRequest) {
        return Mono.fromRunnable(() -> postService.savePost(postRequest.to()));
    }


}