package org.openapitools.service;

import org.openapitools.client.DocumentClient;
import org.openapitools.model.Document;
import org.openapitools.model.DocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class DocumentService {
    private static final Logger logger = LoggerFactory.getLogger(DocumentService.class);

    private final DocumentClient documentClient;

    @Autowired
    public DocumentService(DocumentClient documentClient) {
        this.documentClient = documentClient;
    }

    public Mono<Document> createDocument(Mono<Document> documentMono) {
        return documentMono
                .doOnNext(doc -> logger.info("msg=\"Service create document request\" documentId={}", doc.getId()))
                .flatMap(doc -> documentClient.createDocument(Mono.just(doc))).doOnNext(doc -> logger.info("msg=\"Service created document response\" documentId={}", doc != null ? doc.getId() : null));
    }

    public Mono<Void> deleteDocument(UUID documentId) {
        logger.info("msg=\"Service delete document request\" documentId={}", documentId);
        return documentClient.deleteDocument(documentId)
                .doOnSuccess(v -> logger.info("msg=\"Service deleted document response\" documentId={}", documentId));
    }

    public Mono<Document> getDocument(UUID documentId) {
        logger.info("msg=\"Service get document request\" documentId={}", documentId);
        return documentClient.getDocument(documentId)
                .doOnNext(doc -> logger.info("msg=\"Service got document response\" documentId={}", doc != null ? doc.getId() : null));
    }

    public Mono<DocumentList> listDocuments() {
        logger.info("msg=\"Service list documents request\"");
        return documentClient.listDocuments()
                .doOnNext(list -> logger.info("msg=\"Service listed documents response\" count={}", list != null && list.getItems() != null ? list.getItems().size() : 0));
    }

    public Mono<Document> updateDocument(UUID documentId, Mono<Document> documentMono) {
        logger.info("msg=\"Service update document request\" documentId={}", documentId);
        return documentClient.updateDocument(documentId, documentMono)
                .doOnNext(doc -> logger.info("msg=\"Service updated document response\" documentId={}", doc != null ? doc.getId() : null));
    }
}
