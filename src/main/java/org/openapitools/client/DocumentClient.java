package org.openapitools.client;

import org.openapitools.model.Document;
import org.openapitools.model.DocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class DocumentClient {
    private static final Logger logger = LoggerFactory.getLogger(DocumentClient.class);
    private final WebClient webClient;

    @Autowired
    public DocumentClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Document> createDocument(Mono<Document> documentMono) {
        return documentMono.flatMap(document -> {
            logger.info("msg=\"Client create document request\" documentId={}", document.getId());
            return webClient.post()
                    .uri("/v1/documents")
                    .bodyValue(document)
                    .retrieve()
                    .bodyToMono(Document.class)
                    .doOnNext(resp -> logger.info("msg=\"Client created document response\" documentId={}", resp != null ? resp.getId() : null));
        });
    }

    public Mono<Void> deleteDocument(UUID documentId) {
        logger.info("msg=\"Client delete document request\" documentId={}", documentId);
        return webClient.delete()
                .uri("/v1/documents/{documentId}", documentId)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnSuccess(resp -> logger.info("msg=\"Client deleted document response\" documentId={}", documentId));
    }

    public Mono<Document> getDocument(UUID documentId) {
        logger.info("msg=\"Client get document request\" documentId={}", documentId);
        return webClient.get()
                .uri("/v1/documents/{documentId}", documentId)
                .retrieve()
                .bodyToMono(Document.class)
                .doOnNext(resp -> logger.info("msg=\"Client got document response\" documentId={}", resp != null ? resp.getId() : null));
    }

    public Mono<DocumentList> listDocuments() {
        logger.info("msg=\"Client list documents request\"");
        return webClient.get()
                .uri("/v1/documents")
                .retrieve()
                .bodyToMono(DocumentList.class)
                .doOnNext(resp -> logger.info("msg=\"Client listed documents response\" count={}", resp != null && resp.getItems() != null ? resp.getItems().size() : 0));
    }

    public Mono<Document> updateDocument(UUID documentId, Mono<Document> documentMono) {
        logger.info("msg=\"Client update document request\" documentId={}", documentId);
        return documentMono.flatMap(document -> webClient.put()
                .uri("/v1/documents/{documentId}", documentId)
                .bodyValue(document)
                .retrieve()
                .bodyToMono(Document.class)
                .doOnNext(resp -> logger.info("msg=\"Client updated document response\" documentId={}", resp != null ? resp.getId() : null)));
    }

}
