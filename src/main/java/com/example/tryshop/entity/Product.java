package com.example.tryshop.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name ="Product")
@ToString
@Slf4j
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name="id")
    private Long id;
    private String productName;

    private String price;
    private String description;
    private String quantity;
    @Lob
    private byte[] image;

    public Product(Long id, String productName, String price, String description, String quantity, byte[] image) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.image = image;
    }

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Product(){}

}
