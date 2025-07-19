package com.example.tryshop.mapper;

import com.example.tryshop.dto.ProductDto;
import com.example.tryshop.entity.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                product.getDescription(),
                product.getQuantity()
        );
    }

    public static Product mapToProduct(ProductDto productDto) {
//        return new Product(
//                productDto.getId(),
//                productDto.getProductName(),
//                productDto.getPrice(),
//                productDto.getDescription(),
//                productDto.getQuantity(),
//                productDto.getProductName().getBytes() // Assuming image is stored as bytes, adjust as necessary
//
//        );


        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        product.setProductName(productDto.getProductName());
     //  product.setImage(file.getBytes()); // Assuming image is stored as bytes, adjust as necessary
        return product;
    }
}
