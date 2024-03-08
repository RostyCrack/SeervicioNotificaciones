package com.botech.servicionotificaciones;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
public class Resquest {

    public void sendRequest() {
        log.info("Sending request...");
        String response = WebClient.create()
                .get()
                .uri("http://localhost:8080")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
