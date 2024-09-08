package com.assistant.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebFluxTest(HealthController.class)
@AutoConfigureDataJpa
@DisplayName("헬스 체크 관련 컨트롤러 테스트")
class HealthControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @DisplayName("check health")
    @Test
    public void 헬스_테스트() throws Exception {
        webTestClient.get()
                .uri("/health/check")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(result -> assertEquals(result, "I'm healthy :)"));
    }
}