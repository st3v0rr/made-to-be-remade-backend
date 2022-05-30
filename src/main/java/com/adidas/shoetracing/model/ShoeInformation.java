package com.adidas.shoetracing.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ShoeInformation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-30T16:12:07.132066+02:00[Europe/Berlin]")
public class ShoeInformation   {

  @JsonProperty("id")
  private String id;

  @JsonProperty("pictureUrl")
  private String pictureUrl;

  @JsonProperty("ownerAdressing")
  private String ownerAdressing;

  @JsonProperty("description")
  private String description;

  public ShoeInformation id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ShoeInformation pictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
    return this;
  }

  /**
   * Get pictureUrl
   * @return pictureUrl
  */
  
  @Schema(name = "pictureUrl", required = false)
  public String getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }

  public ShoeInformation ownerAdressing(String ownerAdressing) {
    this.ownerAdressing = ownerAdressing;
    return this;
  }

  /**
   * Get ownerAdressing
   * @return ownerAdressing
  */
  
  @Schema(name = "ownerAdressing", required = false)
  public String getOwnerAdressing() {
    return ownerAdressing;
  }

  public void setOwnerAdressing(String ownerAdressing) {
    this.ownerAdressing = ownerAdressing;
  }

  public ShoeInformation description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", required = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShoeInformation shoeInformation = (ShoeInformation) o;
    return Objects.equals(this.id, shoeInformation.id) &&
        Objects.equals(this.pictureUrl, shoeInformation.pictureUrl) &&
        Objects.equals(this.ownerAdressing, shoeInformation.ownerAdressing) &&
        Objects.equals(this.description, shoeInformation.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, pictureUrl, ownerAdressing, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShoeInformation {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    pictureUrl: ").append(toIndentedString(pictureUrl)).append("\n");
    sb.append("    ownerAdressing: ").append(toIndentedString(ownerAdressing)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

