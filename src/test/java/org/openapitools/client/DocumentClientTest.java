package org.openapitools.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import org.openapitools.model.Document;
import org.openapitools.model.DocumentList;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DocumentClientTest {
    private WebClient webClient;
    private DocumentClient documentClient;

    @BeforeEach
    void setUp() {
        webClient = mock(WebClient.class, RETURNS_DEEP_STUBS);
        documentClient = new DocumentClient(webClient);
    }

    @Test
    void createDocument_callsWebClient() {
        Document doc = new Document();
        doc.setId(UUID.randomUUID());
        WebClient.RequestBodyUriSpec post = mock(WebClient.RequestBodyUriSpec.class);
        WebClient.ResponseSpec responseSpec = mock(WebClient.ResponseSpec.class);
        when(webClient.post()).thenReturn(post);
        when(post.uri("/v1/documents")).thenReturn(post);
        doReturn(post).when(post).bodyValue(any(Document.class));
        when(post.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Document.class)).thenReturn(Mono.just(doc));
        Document result = documentClient.createDocument(Mono.just(doc)).block();
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(doc.getId());
    }

    @Test
    void deleteDocument_callsWebClient() {
        UUID id = UUID.randomUUID();
        WebClient.RequestHeadersUriSpec<?> delete = mock(WebClient.RequestHeadersUriSpec.class, withSettings().extraInterfaces(WebClient.RequestHeadersSpec.class));
        WebClient.ResponseSpec responseSpec = mock(WebClient.ResponseSpec.class);
        doReturn(delete).when(webClient).delete();
        doReturn(delete).when(delete).uri("/v1/documents/{documentId}", id);
        when(delete.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Void.class)).thenReturn(Mono.empty());
        documentClient.deleteDocument(id).block();
        verify(webClient).delete();
    }

    @Test
    void getDocument_callsWebClient() {
        UUID id = UUID.randomUUID();
        Document doc = new Document();
        doc.setId(id);
        WebClient.RequestHeadersUriSpec<?> get = mock(WebClient.RequestHeadersUriSpec.class, withSettings().extraInterfaces(WebClient.RequestHeadersSpec.class));
        WebClient.ResponseSpec responseSpec = mock(WebClient.ResponseSpec.class);
        doReturn(get).when(webClient).get();
        doReturn(get).when(get).uri("/v1/documents/{documentId}", id);
        when(get.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Document.class)).thenReturn(Mono.just(doc));
        Document result = documentClient.getDocument(id).block();
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
    }

    @Test
    void listDocuments_callsWebClient() {
        DocumentList list = new DocumentList();
        WebClient.RequestHeadersUriSpec<?> get = mock(WebClient.RequestHeadersUriSpec.class, withSettings().extraInterfaces(WebClient.RequestHeadersSpec.class));
        WebClient.ResponseSpec responseSpec = mock(WebClient.ResponseSpec.class);
        doReturn(get).when(webClient).get();
        doReturn(get).when(get).uri("/v1/documents");
        when(get.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(DocumentList.class)).thenReturn(Mono.just(list));
        DocumentList result = documentClient.listDocuments().block();
        assertThat(result).isNotNull();
    }

    @Test
    void updateDocument_callsWebClient() {
        UUID id = UUID.randomUUID();
        Document doc = new Document();
        doc.setId(id);
        WebClient.RequestBodyUriSpec put = mock(WebClient.RequestBodyUriSpec.class);
        WebClient.ResponseSpec responseSpec = mock(WebClient.ResponseSpec.class);
        when(webClient.put()).thenReturn(put);
        when(put.uri("/v1/documents/{documentId}", id)).thenReturn(put);
        doReturn(put).when(put).bodyValue(any(Document.class));
        when(put.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Document.class)).thenReturn(Mono.just(doc));
        Document result = documentClient.updateDocument(id, Mono.just(doc)).block();
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
    }
}
