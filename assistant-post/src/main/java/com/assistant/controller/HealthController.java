package com.assistant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/health")
public class HealthController {
    public HealthController() {
    }

    @GetMapping("/check")
    public Mono<String> test() {
        return Mono.just("I'm healthy :)");
    }
}
