/*
 * Api Documentation
 * Api Documentation
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.novaservices.training.webshop.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.novaservices.training.webshop.client.model.Pageable;
import com.novaservices.training.webshop.client.model.Product;
import com.novaservices.training.webshop.client.model.Sort;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * PageProduct
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-03-30T10:28:28.325+02:00")
public class PageProduct {
  @JsonProperty("content")
  private List<Product> content = null;

  @JsonProperty("empty")
  private Boolean empty = null;

  @JsonProperty("first")
  private Boolean first = null;

  @JsonProperty("last")
  private Boolean last = null;

  @JsonProperty("number")
  private Integer number = null;

  @JsonProperty("numberOfElements")
  private Integer numberOfElements = null;

  @JsonProperty("pageable")
  private Pageable pageable = null;

  @JsonProperty("size")
  private Integer size = null;

  @JsonProperty("sort")
  private Sort sort = null;

  @JsonProperty("totalElements")
  private Long totalElements = null;

  @JsonProperty("totalPages")
  private Integer totalPages = null;

  public PageProduct content(List<Product> content) {
    this.content = content;
    return this;
  }

  public PageProduct addContentItem(Product contentItem) {
    if (this.content == null) {
      this.content = new ArrayList<Product>();
    }
    this.content.add(contentItem);
    return this;
  }

   /**
   * Get content
   * @return content
  **/
  @ApiModelProperty(value = "")
  public List<Product> getContent() {
    return content;
  }

  public void setContent(List<Product> content) {
    this.content = content;
  }

  public PageProduct empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

   /**
   * Get empty
   * @return empty
  **/
  @ApiModelProperty(value = "")
  public Boolean isEmpty() {
    return empty;
  }

  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }

  public PageProduct first(Boolean first) {
    this.first = first;
    return this;
  }

   /**
   * Get first
   * @return first
  **/
  @ApiModelProperty(value = "")
  public Boolean isFirst() {
    return first;
  }

  public void setFirst(Boolean first) {
    this.first = first;
  }

  public PageProduct last(Boolean last) {
    this.last = last;
    return this;
  }

   /**
   * Get last
   * @return last
  **/
  @ApiModelProperty(value = "")
  public Boolean isLast() {
    return last;
  }

  public void setLast(Boolean last) {
    this.last = last;
  }

  public PageProduct number(Integer number) {
    this.number = number;
    return this;
  }

   /**
   * Get number
   * @return number
  **/
  @ApiModelProperty(value = "")
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public PageProduct numberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
    return this;
  }

   /**
   * Get numberOfElements
   * @return numberOfElements
  **/
  @ApiModelProperty(value = "")
  public Integer getNumberOfElements() {
    return numberOfElements;
  }

  public void setNumberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
  }

  public PageProduct pageable(Pageable pageable) {
    this.pageable = pageable;
    return this;
  }

   /**
   * Get pageable
   * @return pageable
  **/
  @ApiModelProperty(value = "")
  public Pageable getPageable() {
    return pageable;
  }

  public void setPageable(Pageable pageable) {
    this.pageable = pageable;
  }

  public PageProduct size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @ApiModelProperty(value = "")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public PageProduct sort(Sort sort) {
    this.sort = sort;
    return this;
  }

   /**
   * Get sort
   * @return sort
  **/
  @ApiModelProperty(value = "")
  public Sort getSort() {
    return sort;
  }

  public void setSort(Sort sort) {
    this.sort = sort;
  }

  public PageProduct totalElements(Long totalElements) {
    this.totalElements = totalElements;
    return this;
  }

   /**
   * Get totalElements
   * @return totalElements
  **/
  @ApiModelProperty(value = "")
  public Long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Long totalElements) {
    this.totalElements = totalElements;
  }

  public PageProduct totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

   /**
   * Get totalPages
   * @return totalPages
  **/
  @ApiModelProperty(value = "")
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageProduct pageProduct = (PageProduct) o;
    return Objects.equals(this.content, pageProduct.content) &&
        Objects.equals(this.empty, pageProduct.empty) &&
        Objects.equals(this.first, pageProduct.first) &&
        Objects.equals(this.last, pageProduct.last) &&
        Objects.equals(this.number, pageProduct.number) &&
        Objects.equals(this.numberOfElements, pageProduct.numberOfElements) &&
        Objects.equals(this.pageable, pageProduct.pageable) &&
        Objects.equals(this.size, pageProduct.size) &&
        Objects.equals(this.sort, pageProduct.sort) &&
        Objects.equals(this.totalElements, pageProduct.totalElements) &&
        Objects.equals(this.totalPages, pageProduct.totalPages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, empty, first, last, number, numberOfElements, pageable, size, sort, totalElements, totalPages);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageProduct {\n");
    
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    numberOfElements: ").append(toIndentedString(numberOfElements)).append("\n");
    sb.append("    pageable: ").append(toIndentedString(pageable)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

