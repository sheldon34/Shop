package com.example.tryshop.controller;

import com.example.tryshop.dto.ProductDto;
import com.example.tryshop.repo.ProductRepo;
import com.example.tryshop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;
    private ProductRepo productRepo;
    private ProductDto productDto;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    // creating a new product
@PostMapping("/upload")
   public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto product=productService.createProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

// getting all products
@GetMapping("/getAll")
public ResponseEntity<Map<String, Object> >getAllProducts(
//@RequestBody ProductDto productDto
        @RequestParam(value="pageNo", defaultValue="0" ,required=false)
        int pageNo,
        @RequestParam(value ="pageSize", defaultValue="10",required=false)
        int pageSize,
        @RequestParam(value="sortBy", defaultValue = "id") String sortBy,
        @RequestParam(value="sortDirection", defaultValue = "asc") String sortDirection
){

        try {
            Page<ProductDto> product = productService.getAllProducts(pageNo, pageSize, sortBy, sortDirection);

//showing meta data
            Map<String, Object> response = new HashMap<>();
            response.put("products", product.getContent());
            response.put("currentPage", product.getNumber());
            response.put("totalItems", product.getTotalElements());
            response.put("totalPages", product.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
            // Log the error or handle it as needed
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    // updating a product


    @PatchMapping("/update/{id}")
    ResponseEntity<ProductDto> updateProduct( @PathVariable("id") Long id,
                                              @RequestBody ProductDto productDto){
        ProductDto product = productService.updateProduct(id, productDto);
        return ResponseEntity.ok().body(product);
    }

/// getting a product by id
@GetMapping("/getById/{id}")
ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
    ProductDto product = productService.getProductById(id);
    return new ResponseEntity<>(product, HttpStatus.OK);
}

///  delelting a product
@DeleteMapping("/delete/{id}")
        ResponseEntity<String > deleteProductById(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().body("Deleted Product");

}
// Uploading the Image
    @PostMapping("/uploadImage")
    @CrossOrigin(origins = "http://localhost:5173")
public ResponseEntity<String>  uploadProduct(
        @RequestParam("name") String name,
        @RequestParam("Image") MultipartFile file
    )
    {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(name);
        try {
            productService.savedProduct(productDto,file);
            return ResponseEntity.ok().body("Product uploaded");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Product not uploaded");
        }
    }
}
