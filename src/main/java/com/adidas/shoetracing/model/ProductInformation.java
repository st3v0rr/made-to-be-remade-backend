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
 * ProductInformation
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-30T23:30:32.507993+02:00[Europe/Berlin]")
public class ProductInformation   {

  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("price")
  private String price;

  @JsonProperty("description")
  private String description;

  @JsonProperty("imageUrl")
  private String imageUrl;

  @JsonProperty("owner")
  private String owner;

  @JsonProperty("ownerAdress")
  private String ownerAdress;

  public ProductInformation id(String id) {
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

  public ProductInformation name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductInformation price(String price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  
  @Schema(name = "price", required = false)
  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public ProductInformation description(String description) {
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

  public ProductInformation imageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  /**
   * Get imageUrl
   * @return imageUrl
  */
  
  @Schema(name = "imageUrl", required = false)
  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public ProductInformation owner(String owner) {
    this.owner = owner;
    return this;
  }

  /**
   * Get owner
   * @return owner
  */
  
  @Schema(name = "owner", required = false)
  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public ProductInformation ownerAdress(String ownerAdress) {
    this.ownerAdress = ownerAdress;
    return this;
  }

  /**
   * Get ownerAdress
   * @return ownerAdress
  */
  
  @Schema(name = "ownerAdress", required = false)
  public String getOwnerAdress() {
    return ownerAdress;
  }

  public void setOwnerAdress(String ownerAdress) {
    this.ownerAdress = ownerAdress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductInformation productInformation = (ProductInformation) o;
    return Objects.equals(this.id, productInformation.id) &&
        Objects.equals(this.name, productInformation.name) &&
        Objects.equals(this.price, productInformation.price) &&
        Objects.equals(this.description, productInformation.description) &&
        Objects.equals(this.imageUrl, productInformation.imageUrl) &&
        Objects.equals(this.owner, productInformation.owner) &&
        Objects.equals(this.ownerAdress, productInformation.ownerAdress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price, description, imageUrl, owner, ownerAdress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductInformation {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    ownerAdress: ").append(toIndentedString(ownerAdress)).append("\n");
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

