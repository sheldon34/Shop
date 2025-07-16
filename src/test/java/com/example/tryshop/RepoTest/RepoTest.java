package com.example.tryshop.RepoTest;

import com.example.tryshop.Entity.Product;
import com.example.tryshop.Repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@DataJpaTest
public class RepoTest {
    @Autowired
    private ProductRepo productRepo;

   private Product product;

    @BeforeEach
    public void setup(){
        product= Product.builder()
                .productName("product name")
                .description("product description")
                .price("mmomkom")
                .quantity("njkkj k")
                .image(new byte[]{1, 2, 3, 4, 5})

                .build();


    }
    @Test
    public void ProductRepo_SaveAll_ReturnSavedProduct(){
        /// act
        Product product1= productRepo.save(product);
        /// Assert
        Assertions.assertThat(product1).isNotNull();
        Assertions.assertThat(product1.getId()).isGreaterThan(0);
        Assertions.assertThat(product1.getProductName()).isEqualTo("product name");
    }
    @Test
    public void ProductRepo_GetAll_ReturnSavedProducts(){

        List<Product> products= new ArrayList<>();
        products.add(product);
        products.add(Product.builder()
                        .quantity("njkkj k")
                        .description("product description2")
                        .price("mmomkom2")
                        .productName("product name2")
                        .image(new byte[]{1, 2, 3, 4, 5})

                .build());
        List <Product> savedProducts= productRepo.saveAll(products);
        /// Assert
        Assertions.assertThat(savedProducts).isNotNull();
        Assertions.assertThat(savedProducts.size()).isEqualTo(2);
    }

    @Test
    public void ProductRepo_UpdateProduct_ReturnUpdatedProduct(){

        //Act
        Product savedProduct = productRepo.save(product);
        Product updatedProduct=productRepo.findById(savedProduct.getId()).get();
        updatedProduct.setProductName("updated product name");
        updatedProduct.setDescription("updated product description");
        /// Assertions
        Assertions.assertThat(updatedProduct.getProductName()).isEqualTo("updated product name");
        Assertions.assertThat(updatedProduct.getDescription()).isEqualTo("updated product description");
        Assertions.assertThat(updatedProduct.getId()).isEqualTo(savedProduct.getId());
    }

    @Test
    public void ProductRepo_GetById_ReturnProduct(){
        //act
        Product savedProduct=productRepo.save(product);
        Product product1=productRepo.findById(savedProduct.getId()).get();
        //Assert

        Assertions.assertThat(product1).isNotNull();
        Assertions.assertThat(product1.getId()).isEqualTo(savedProduct.getId());
    }
@Test
public void ProductRepo_DeleteById_ReturnDeletedProduct(){
        //Act
Product savedProduct=productRepo.save(product);
        productRepo.deleteById(savedProduct.getId());
Optional<Product> deletedProduct=productRepo.findById(savedProduct.getId());
        //Assert
    Assertions.assertThat(deletedProduct).isEmpty();

    Assertions.assertThat(deletedProduct).isNotEqualTo(savedProduct);
}




}
