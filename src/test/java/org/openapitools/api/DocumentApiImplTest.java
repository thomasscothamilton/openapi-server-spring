package org.openapitools.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.model.Document;
import org.openapitools.model.DocumentList;
import org.openapitools.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class DocumentApiImplTest {
    @Mock
    private DocumentService documentService;
    @Mock
    private ServerWebExchange exchange;
    @InjectMocks
    private DocumentApiImpl documentApiImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void documentsPost_returnsCreated() {
        Document doc = new Document();
        doc.setId(UUID.randomUUID());
        when(documentService.createDocument(any())).thenReturn(Mono.just(doc));
        ResponseEntity<Document> response = documentApiImpl.documentsPost(Mono.just(doc), exchange).block();
        assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        assertThat(response.getBody()).isEqualTo(doc);
    }

    @Test
    void documentsDocumentIdDelete_returnsNoContent() {
        UUID id = UUID.randomUUID();
        when(documentService.deleteDocument(id)).thenReturn(Mono.empty());
        ResponseEntity<Void> response = documentApiImpl.documentsDocumentIdDelete(id, exchange).block();
        assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(204);
    }

    @Test
    void documentsDocumentIdGet_returnsOk() {
        UUID id = UUID.randomUUID();
        Document doc = new Document();
        doc.setId(id);
        when(documentService.getDocument(id)).thenReturn(Mono.just(doc));
        ResponseEntity<Document> response = documentApiImpl.documentsDocumentIdGet(id, exchange).block();
        assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(doc);
    }

    @Test
    void listDocuments_returnsOk() {
        DocumentList list = new DocumentList();
        list.setItems(Collections.emptyList());
        when(documentService.listDocuments()).thenReturn(Mono.just(list));
        ResponseEntity<DocumentList> response = documentApiImpl.listDocuments(exchange).block();
        assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(list);
    }

    @Test
    void documentsDocumentIdPut_returnsOk() {
        UUID id = UUID.randomUUID();
        Document doc = new Document();
        doc.setId(id);
        when(documentService.updateDocument(eq(id), any())).thenReturn(Mono.just(doc));
        ResponseEntity<Document> response = documentApiImpl.documentsDocumentIdPut(id, Mono.just(doc), exchange).block();
        assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(doc);
    }
}
