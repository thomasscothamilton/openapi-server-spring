package org.openapitools.api;

import org.openapitools.model.Document;
import org.openapitools.model.DocumentList;
import org.openapitools.model.Error;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-19T14:08:09.921984-04:00[America/New_York]", comments = "Generator version: 7.13.0")
@Controller
@RequestMapping("${openapi.documentService.base-path:}")
public class DocumentsApiController implements DocumentsApi {

    private final DocumentsApiDelegate delegate;

    public DocumentsApiController(@Autowired(required = false) DocumentsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new DocumentsApiDelegate() {});
    }

    @Override
    public DocumentsApiDelegate getDelegate() {
        return delegate;
    }

}
