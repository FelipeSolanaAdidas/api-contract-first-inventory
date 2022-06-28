package com.adidas.apiteam.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Stock
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-28T08:58:01.753082800+02:00[Europe/Paris]")


public class Stock   {
  @JsonProperty("availableItems")
  private BigDecimal availableItems = null;

  @JsonProperty("color")
  private String color = null;

  public Stock availableItems(BigDecimal availableItems) {
    this.availableItems = availableItems;
    return this;
  }

  /**
   * Get availableItems
   * @return availableItems
   **/
  @Schema(example = "10", description = "")
  
    @Valid
    public BigDecimal getAvailableItems() {
    return availableItems;
  }

  public void setAvailableItems(BigDecimal availableItems) {
    this.availableItems = availableItems;
  }

  public Stock color(String color) {
    this.color = color;
    return this;
  }

  /**
   * Get color
   * @return color
   **/
  @Schema(example = "red", description = "")
  
    public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stock stock = (Stock) o;
    return Objects.equals(this.availableItems, stock.availableItems) &&
        Objects.equals(this.color, stock.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availableItems, color);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stock {\n");
    
    sb.append("    availableItems: ").append(toIndentedString(availableItems)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
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
