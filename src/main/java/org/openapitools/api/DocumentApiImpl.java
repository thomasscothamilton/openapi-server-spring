package org.openapitools.api;

import org.openapitools.model.Document;
import org.openapitools.model.DocumentList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.openapitools.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DocumentApiImpl implements DocumentsApiDelegate {
    private static final Logger logger = LoggerFactory.getLogger(DocumentApiImpl.class);
    private final DocumentService documentService;

    @Autowired
    public DocumentApiImpl(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Override
    public Mono<ResponseEntity<Document>> documentsPost(Mono<Document> documentMono, ServerWebExchange exchange) {
        return documentMono
                .flatMap(doc -> {
                    // Business logic: reject empty title
                    if (doc.getTitle() == null || doc.getTitle().trim().isEmpty()) {
                        return Mono.error(new IllegalArgumentException("Document title must not be empty"));
                    }

                    // Business logic: set created timestamp if not set
                    if (doc.getCreatedAt() == null) {
                        doc.setCreatedAt(java.time.OffsetDateTime.now());
                    }

                    logger.info("msg=\"Service create document request\" documentId={}", doc.getId());
                    return documentService.createDocument(Mono.just(doc));
                })
                .doOnNext(doc -> logger.info("msg=\"Service created document response\" documentId={}", doc != null ? doc.getId() : null))
                .map(d -> ResponseEntity.status(HttpStatus.CREATED).body(d));
    }

    @Override
    public Mono<ResponseEntity<Void>> documentsDocumentIdDelete(UUID documentId, ServerWebExchange exchange) {
        logger.info("msg=\"API delete document request\" documentId={}", documentId);
        return documentService.deleteDocument(documentId)
                .doOnSuccess(v -> logger.info("msg=\"API deleted document response\" documentId={}", documentId))
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

    @Override
    public Mono<ResponseEntity<Document>> documentsDocumentIdGet(UUID documentId, ServerWebExchange exchange) {
        logger.info("msg=\"API get document request\" documentId={}", documentId);
        return documentService.getDocument(documentId)
                .doOnNext(doc -> logger.info("msg=\"API got document response\" documentId={}", doc != null ? doc.getId() : null))
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<DocumentList>> listDocuments(ServerWebExchange exchange) {
        logger.info("msg=\"API list documents request\"");
        return documentService.listDocuments()
                .doOnNext(list -> logger.info("msg=\"API listed documents response\" count={}", list != null && list.getItems() != null ? list.getItems().size() : 0))
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Document>> documentsDocumentIdPut(UUID documentId, Mono<Document> documentMono, ServerWebExchange exchange) {
        logger.info("msg=\"API update document request\" documentId={}", documentId);
        return documentService.updateDocument(documentId, documentMono)
                .doOnNext(doc -> logger.info("msg=\"API updated document response\" documentId={}", doc.getId()))
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Document>> v1DocumentsPost(Mono<Document> document, ServerWebExchange exchange) {
        Document sample = new Document();
        sample.setId(java.util.UUID.randomUUID());
        sample.setTitle("Test Document");
        sample.setContentType("application/pdf");
        sample.setCreatedAt(java.time.OffsetDateTime.now());
        sample.setUpdatedAt(java.time.OffsetDateTime.now());

        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(sample));
    }
}
