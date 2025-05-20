package org.openapitools.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class GlobalExceptionHandlerTest {
    private GlobalExceptionHandler handler;

    @BeforeEach
    void setUp() {
        handler = new GlobalExceptionHandler();
    }

    @Test
    void handleWebClientResponseException_returnsCorrectStatusAndBody() {
        WebClientResponseException ex = mock(WebClientResponseException.class);
        org.mockito.Mockito.when(ex.getStatusCode()).thenReturn(HttpStatus.NOT_IMPLEMENTED);
        org.mockito.Mockito.when(ex.getStatusText()).thenReturn("Not Implemented");
        org.mockito.Mockito.when(ex.getMessage()).thenReturn("501 Not Implemented");
        ResponseEntity<String> response = handler.handleWebClientResponseException(ex);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_IMPLEMENTED);
        assertThat(response.getBody()).isEqualTo("501 Not Implemented");
    }

    @Test
    void handleWebClientResponseException_nullMessage_returnsStatusText() {
        WebClientResponseException ex = mock(WebClientResponseException.class);
        org.mockito.Mockito.when(ex.getStatusCode()).thenReturn(HttpStatus.NOT_IMPLEMENTED);
        org.mockito.Mockito.when(ex.getStatusText()).thenReturn("Not Implemented");
        org.mockito.Mockito.when(ex.getMessage()).thenReturn(null);
        ResponseEntity<String> response = handler.handleWebClientResponseException(ex);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_IMPLEMENTED);
        assertThat(response.getBody()).isEqualTo("Not Implemented");
    }
}
