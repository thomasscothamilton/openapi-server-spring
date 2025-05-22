package org.openapitools.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DocumentIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void shouldCreateDocumentSuccessfully() {
        String requestBody = """
        {
            "title": "Test Document",
            "contentType": "application/pdf",
            "size": 12345
        }
        """;

        webTestClient.post()
                .uri("/documents")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.title").isEqualTo("Test Document")
                .jsonPath("$.contentType").isEqualTo("application/pdf")
                .jsonPath("$.createdAt").value(createdAt -> {
                    assertThatCode(() -> ZonedDateTime.parse((String) createdAt, DateTimeFormatter.ISO_DATE_TIME))
                            .doesNotThrowAnyException();
                });
    }
}
