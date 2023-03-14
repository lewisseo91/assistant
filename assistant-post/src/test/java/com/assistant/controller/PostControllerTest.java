package com.assistant.controller;

import com.assistant.dto.PostRequest;
import com.assistant.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(PostController.class)
@AutoConfigureDataJpa
@Import(PostService.class)
@DisplayName("포스트 관련 컨트롤러 테스트")
class PostControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private PostService service;

    @Test
    @DisplayName("포스트 저장이 된다.")
    public void 포스트를_저장한다() throws Exception {
        PostRequest 포스트_1번 = new PostRequest(1L, 1L, "1번포스트");

        webTestClient.post()
                .uri("/post/save")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(포스트_1번)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Void.class);
    }

    @Test
    @DisplayName("포스트 수정이 된다.")
    public void 포스트를_수정한다() throws Exception {
        // given
        포스트를_저장한다();

        PostRequest 포스트_1번 = new PostRequest(1L, 1L, "1번포스트_수정");

        webTestClient.put()
                .uri("/post/update")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(포스트_1번)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Void.class);
    }

    @Test
    @DisplayName("포스트 삭제가 된다.")
    public void 포스트를_삭제한다() throws Exception {
        // given
        포스트를_저장한다();

        long id = 1L;

        webTestClient.delete()
                .uri("/post/delete/" + id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Void.class);
    }
}