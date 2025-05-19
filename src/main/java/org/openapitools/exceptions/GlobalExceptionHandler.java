package org.openapitools.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleWebClientResponseException(WebClientResponseException ex) {
        logger.warn("msg=\"ControllerAdvice caught exception\" status={} reason=\"{}\"", ex.getStatusText(), ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode())
                .body(ex.getMessage() != null ? ex.getMessage() : ex.getStatusText());
    }
}
