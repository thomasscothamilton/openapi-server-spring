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
    public Mono<ResponseEntity<Document>> documentsPost(Mono<Document> documentCreateMono, ServerWebExchange exchange) {
        return documentCreateMono
            .doOnNext(doc -> logger.info("msg=\"API create document request\" documentId={}", doc.getId()))
            .flatMap(doc -> documentService.createDocument(Mono.just(doc)))
            .doOnNext(doc -> logger.info("msg=\"API created document response\" documentId={}", doc.getId()))
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
}
