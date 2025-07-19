package com.example.tryshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
    private Long id;
   // @JsonProperty("ProductName")
    private String productName;
    private String price;
    private String description;
    private String quantity;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }



    public ProductDto(Long id, String productName, String price, String description, String quantity, byte[] image) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }
}
