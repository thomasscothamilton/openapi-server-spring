package org.openapitools.config;

import org.junit.jupiter.api.Test;
import org.openapitools.client.DocumentClient;
import org.springframework.web.reactive.function.client.WebClient;

import static org.assertj.core.api.Assertions.assertThat;

class WebClientConfigTest {
    @Test
    void webClient_createsWithBaseUrl() {
        String baseUrl = "http://localhost:8080";
        WebClient client = new WebClientConfig().webClient(baseUrl);
        assertThat(client).isNotNull();
    }

    @Test
    void documentClient_createsWithWebClient() {
        WebClient webClient = WebClient.create();
        DocumentClient client = new WebClientConfig().documentClient(webClient);
        assertThat(client).isNotNull();
    }
}
