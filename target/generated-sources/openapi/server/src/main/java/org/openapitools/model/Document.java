package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Document
 */
@lombok.Getter @lombok.Setter

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-19T14:08:09.921984-04:00[America/New_York]", comments = "Generator version: 7.13.0")
public class Document {

  private UUID id;

  private String title;

  private @Nullable String description;

  private String contentType;

  private Integer size;

  private @Nullable String checksum;

  private @Nullable UUID latestVersionId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime updatedAt;

  public Document() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Document(UUID id, String title, String contentType, Integer size, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
    this.id = id;
    this.title = title;
    this.contentType = contentType;
    this.size = size;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Document id(UUID id) {
    this.id = id;
    return this;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Document title(String title) {
    this.title = title;
    return this;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Document description(String description) {
    this.description = description;
    return this;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Document contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public Document size(Integer size) {
    this.size = size;
    return this;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Document checksum(String checksum) {
    this.checksum = checksum;
    return this;
  }

  public void setChecksum(String checksum) {
    this.checksum = checksum;
  }

  public Document latestVersionId(UUID latestVersionId) {
    this.latestVersionId = latestVersionId;
    return this;
  }

  public void setLatestVersionId(UUID latestVersionId) {
    this.latestVersionId = latestVersionId;
  }

  public Document createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Document updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Document document = (Document) o;
    return Objects.equals(this.id, document.id) &&
        Objects.equals(this.title, document.title) &&
        Objects.equals(this.description, document.description) &&
        Objects.equals(this.contentType, document.contentType) &&
        Objects.equals(this.size, document.size) &&
        Objects.equals(this.checksum, document.checksum) &&
        Objects.equals(this.latestVersionId, document.latestVersionId) &&
        Objects.equals(this.createdAt, document.createdAt) &&
        Objects.equals(this.updatedAt, document.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, contentType, size, checksum, latestVersionId, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Document {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
    sb.append("    latestVersionId: ").append(toIndentedString(latestVersionId)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

