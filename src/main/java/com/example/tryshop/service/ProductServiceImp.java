package com.example.tryshop.service;

import com.example.tryshop.dto.ProductDto;
import com.example.tryshop.entity.Product;
import com.example.tryshop.mapper.ProductMapper;
import com.example.tryshop.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Slf4j
public class ProductServiceImp implements  ProductService{

    private ProductRepo productRepo;
    public ProductServiceImp(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        try {
            Product product = ProductMapper.mapToProduct(productDto);
            Product savedProduct = productRepo.save(product);
            return ProductMapper.mapToProductDto(savedProduct);
        }
       catch (Exception e) {
            throw new RuntimeException("new upload failed"+e.getMessage());
       }

    }
    @Override
    public ProductDto getProductById(Long productId) {
        Product product=productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        return ProductMapper.mapToProductDto(product);
    }

/// impimenting pagation
    @Override
    public Page<ProductDto> getAllProducts(int pageNo,int pageSize, String sortBy, String sortDirection) {
       // Sort.Direction SortDirection=Sort.Direction.fromString(sortDirection);// for example, "asc" or "desc" for sorting direction
        Sort sort = sortDirection.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(pageNo, pageSize, sort); // Create a Pageable object with the specified page number, page size, and sorting criteria
        Page<Product> productsPage= productRepo.findAll(pageable);
        List<ProductDto> productDto=productsPage.getContent().stream()
                .map(product->ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());

        return new PageImpl<>(productDto,pageable,productsPage.getTotalElements());
//List<Product> productList= products.getContent();
////List<ProductDto> content =productList.str
//
//
//        return productList.stream().map((product)
//                ->ProductMapper.mapToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProductDto) {
        log.info("{}", updatedProductDto);

try{
            Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
            // Update the product fields with the new values from updatedProductDto
            product.setProductName(updatedProductDto.getProductName());
            product.setPrice(updatedProductDto.getPrice());
            product.setDescription(updatedProductDto.getDescription());
            product.setQuantity(updatedProductDto.getQuantity());

            // Product updateProduct=ProductMapper.mapToProduct(updatedProductDto);

            log.info("--00{}", product);
            Product product1 = productRepo.save(product);
            log.info("9999{}", product1);
            return ProductMapper.mapToProductDto(product1);}
        catch (Exception e){
   // log.error("Error updating product: {}", e.getMessage());
            throw new RuntimeException("Error updating product: " + e.getMessage());
        }

    }

    @Override
    public void savedProduct(ProductDto productDto, MultipartFile file) throws IOException {
        Product product=new Product();
        product.setProductName(productDto.getProductName());
        product.setImage(file.getBytes());

        Product saveImage = productRepo.save(product);


    }

    @Override
    public void deleteProduct(Long productId) {
productRepo.deleteById(productId);
    }
}
