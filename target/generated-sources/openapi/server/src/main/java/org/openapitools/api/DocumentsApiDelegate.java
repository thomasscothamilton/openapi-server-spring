package org.openapitools.api;

import org.openapitools.model.Document;
import org.openapitools.model.DocumentList;
import org.openapitools.model.Error;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link DocumentsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-19T14:08:09.921984-04:00[America/New_York]", comments = "Generator version: 7.13.0")
public interface DocumentsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /documents/{documentId} : Permanently delete a document
     *
     * @param documentId Unique document identifier (UUID) (required)
     * @return Document removed (status code 204)
     *         or Resource not found (status code 404)
     * @see DocumentsApi#documentsDocumentIdDelete
     */
    default Mono<ResponseEntity<Void>> documentsDocumentIdDelete(UUID documentId,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * GET /documents/{documentId} : Retrieve a document’s metadata
     *
     * @param documentId Unique document identifier (UUID) (required)
     * @return Metadata returned (status code 200)
     *         or Resource not found (status code 404)
     * @see DocumentsApi#documentsDocumentIdGet
     */
    default Mono<ResponseEntity<Document>> documentsDocumentIdGet(UUID documentId,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"size\" : 0, \"checksum\" : \"checksum\", \"description\" : \"description\", \"latestVersionId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"contentType\" : \"application/pdf\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * PUT /documents/{documentId} : Replace document metadata
     *
     * @param documentId Unique document identifier (UUID) (required)
     * @param document  (required)
     * @return A single document (status code 200)
     *         or Validation failed (status code 400)
     *         or Resource not found (status code 404)
     * @see DocumentsApi#documentsDocumentIdPut
     */
    default Mono<ResponseEntity<Document>> documentsDocumentIdPut(UUID documentId,
        Mono<Document> document,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"size\" : 0, \"checksum\" : \"checksum\", \"description\" : \"description\", \"latestVersionId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"contentType\" : \"application/pdf\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(document).then(Mono.empty());

    }

    /**
     * POST /documents : Create a new document
     *
     * @param document  (required)
     * @return Document created (status code 201)
     *         or Validation failed (status code 400)
     *         or Authentication failed (status code 401)
     * @see DocumentsApi#documentsPost
     */
    default Mono<ResponseEntity<Document>> documentsPost(Mono<Document> document,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"size\" : 0, \"checksum\" : \"checksum\", \"description\" : \"description\", \"latestVersionId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"contentType\" : \"application/pdf\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(document).then(Mono.empty());

    }

    /**
     * GET /documents : List documents
     *
     * @return Paginated list of documents (status code 200)
     *         or Authentication failed (status code 401)
     * @see DocumentsApi#listDocuments
     */
    default Mono<ResponseEntity<DocumentList>> listDocuments(ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"items\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"size\" : 0, \"checksum\" : \"checksum\", \"description\" : \"description\", \"latestVersionId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"contentType\" : \"application/pdf\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"size\" : 0, \"checksum\" : \"checksum\", \"description\" : \"description\", \"latestVersionId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"contentType\" : \"application/pdf\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ] }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * DELETE /v1/documents/{documentId} : Permanently delete a document
     *
     * @param documentId Unique document identifier (UUID) (required)
     * @return Document removed (status code 204)
     *         or Resource not found (status code 404)
     * @see DocumentsApi#v1DocumentsDocumentIdDelete
     */
    default Mono<ResponseEntity<Void>> v1DocumentsDocumentIdDelete(UUID documentId,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * GET /v1/documents/{documentId} : Retrieve a document’s metadata
     *
     * @param documentId Unique document identifier (UUID) (required)
     * @return Metadata returned (status code 200)
     *         or Resource not found (status code 404)
     * @see DocumentsApi#v1DocumentsDocumentIdGet
     */
    default Mono<ResponseEntity<Document>> v1DocumentsDocumentIdGet(UUID documentId,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"size\" : 0, \"checksum\" : \"checksum\", \"description\" : \"description\", \"latestVersionId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"contentType\" : \"application/pdf\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * PUT /v1/documents/{documentId} : Replace document metadata
     *
     * @param documentId Unique document identifier (UUID) (required)
     * @param document  (required)
     * @return A single document (status code 200)
     *         or Validation failed (status code 400)
     *         or Resource not found (status code 404)
     * @see DocumentsApi#v1DocumentsDocumentIdPut
     */
    default Mono<ResponseEntity<Document>> v1DocumentsDocumentIdPut(UUID documentId,
        Mono<Document> document,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"size\" : 0, \"checksum\" : \"checksum\", \"description\" : \"description\", \"latestVersionId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"contentType\" : \"application/pdf\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(document).then(Mono.empty());

    }

    /**
     * GET /v1/documents : List documents
     *
     * @return Paginated list of documents (status code 200)
     *         or Authentication failed (status code 401)
     * @see DocumentsApi#v1DocumentsGet
     */
    default Mono<ResponseEntity<DocumentList>> v1DocumentsGet(ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"items\" : [ { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"size\" : 0, \"checksum\" : \"checksum\", \"description\" : \"description\", \"latestVersionId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"contentType\" : \"application/pdf\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"size\" : 0, \"checksum\" : \"checksum\", \"description\" : \"description\", \"latestVersionId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"contentType\" : \"application/pdf\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" } ] }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * POST /v1/documents : Create a new document
     *
     * @param document  (required)
     * @return Document created (status code 201)
     *         or Validation failed (status code 400)
     *         or Authentication failed (status code 401)
     * @see DocumentsApi#v1DocumentsPost
     */
    default Mono<ResponseEntity<Document>> v1DocumentsPost(Mono<Document> document,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"size\" : 0, \"checksum\" : \"checksum\", \"description\" : \"description\", \"latestVersionId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"title\" : \"title\", \"contentType\" : \"application/pdf\", \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : \"NOT_FOUND\", \"details\" : [ { \"field\" : \"field\", \"issue\" : \"issue\" }, { \"field\" : \"field\", \"issue\" : \"issue\" } ], \"message\" : \"Document not found\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(document).then(Mono.empty());

    }

}
