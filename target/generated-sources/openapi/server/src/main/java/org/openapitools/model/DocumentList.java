package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.Document;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * DocumentList
 */
@lombok.Getter @lombok.Setter

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-19T14:08:09.921984-04:00[America/New_York]", comments = "Generator version: 7.13.0")
public class DocumentList {

  @Valid
  private List<@Valid Document> items = new ArrayList<>();

  public DocumentList() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DocumentList(List<@Valid Document> items) {
    this.items = items;
  }

  public DocumentList items(List<@Valid Document> items) {
    this.items = items;
    return this;
  }

  public DocumentList addItemsItem(Document itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  public void setItems(List<@Valid Document> items) {
    this.items = items;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentList documentList = (DocumentList) o;
    return Objects.equals(this.items, documentList.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentList {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

