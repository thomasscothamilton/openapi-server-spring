package org.openapitools.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.client.DocumentClient;
import org.openapitools.model.Document;
import org.openapitools.model.DocumentList;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class DocumentServiceTest {
    @Mock
    private DocumentClient documentClient;

    @InjectMocks
    private DocumentService documentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDocument_delegatesToClient() {
        Document doc = new Document();
        doc.setId(UUID.randomUUID());
        when(documentClient.createDocument(any())).thenReturn(Mono.just(doc));

        Document result = documentService.createDocument(Mono.just(doc)).block();
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(doc.getId());
        verify(documentClient).createDocument(any());
    }

    @Test
    void deleteDocument_delegatesToClient() {
        UUID id = UUID.randomUUID();
        when(documentClient.deleteDocument(id)).thenReturn(Mono.empty());
        documentService.deleteDocument(id).block();
        verify(documentClient).deleteDocument(id);
    }

    @Test
    void getDocument_delegatesToClient() {
        UUID id = UUID.randomUUID();
        Document doc = new Document();
        doc.setId(id);
        when(documentClient.getDocument(id)).thenReturn(Mono.just(doc));
        Document result = documentService.getDocument(id).block();
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        verify(documentClient).getDocument(id);
    }

    @Test
    void listDocuments_delegatesToClient() {
        DocumentList list = new DocumentList();
        list.setItems(Collections.emptyList());
        when(documentClient.listDocuments()).thenReturn(Mono.just(list));
        DocumentList result = documentService.listDocuments().block();
        assertThat(result).isNotNull();
        verify(documentClient).listDocuments();
    }

    @Test
    void updateDocument_delegatesToClient() {
        UUID id = UUID.randomUUID();
        Document doc = new Document();
        doc.setId(id);
        when(documentClient.updateDocument(eq(id), any())).thenReturn(Mono.just(doc));
        Document result = documentService.updateDocument(id, Mono.just(doc)).block();
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        verify(documentClient).updateDocument(eq(id), any());
    }
}
