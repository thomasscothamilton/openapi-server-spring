package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ErrorDetailsInner
 */
@lombok.Getter @lombok.Setter

@JsonTypeName("Error_details_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-19T14:08:09.921984-04:00[America/New_York]", comments = "Generator version: 7.13.0")
public class ErrorDetailsInner {

  private String field;

  private String issue;

  public ErrorDetailsInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorDetailsInner(String field, String issue) {
    this.field = field;
    this.issue = issue;
  }

  public ErrorDetailsInner field(String field) {
    this.field = field;
    return this;
  }

  public void setField(String field) {
    this.field = field;
  }

  public ErrorDetailsInner issue(String issue) {
    this.issue = issue;
    return this;
  }

  public void setIssue(String issue) {
    this.issue = issue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDetailsInner errorDetailsInner = (ErrorDetailsInner) o;
    return Objects.equals(this.field, errorDetailsInner.field) &&
        Objects.equals(this.issue, errorDetailsInner.issue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, issue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDetailsInner {\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    issue: ").append(toIndentedString(issue)).append("\n");
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

