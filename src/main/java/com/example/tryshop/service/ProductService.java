package com.example.tryshop.service;

import com.example.tryshop.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {


    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);

    Page<ProductDto> getAllProducts(int pageNo, int pageSize ,String sortBy, String sortDirection);

    ProductDto updateProduct(Long productId, ProductDto updatedProductDto);
    void savedProduct(ProductDto productDto , MultipartFile file )throws IOException;

    void deleteProduct(Long productId);
}
