package com.portobello.eval.api;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Request {

    public static String sendRequest(String endpoint, HttpMethod method, String body) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        final ResponseEntity<String> exchange = restTemplate.exchange(endpoint, method, entity, String.class);
        return exchange.getBody();
    }
}
