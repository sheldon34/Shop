//package com.example.tryshop;
//
//import com.example.tryshop.Dto.ProductDto;
//import com.example.tryshop.Entity.Product;
//import com.example.tryshop.Repo.ProductRepo;
//import com.example.tryshop.Service.ProductService;
//import com.example.tryshop.Service.ProductServiceImp;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.jupiter.api.BeforeEach;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//    @Slf4j
//class TryshopApplicationTests {
//    @InjectMocks
//
//    private ProductServiceImp productServiceImp;
//    @Mock
//    private ProductRepo productRepo;
//
//    private Product product;
//    private ProductDto productDto;
//
//    @BeforeEach
//    public void init(){
//
//        product = Product.builder()
//                .productName("productName")
//                .price("2121311")
//                .description("description")
//                .quantity("quantity")
//                .image(new byte[]{1, 2, 3, 4, 5})
//                .build();
//        productDto = ProductDto.builder()
//                .productName("productName")
//                .description("description")
//                .quantity("quantity")
//                .price("2121311")
//                .Image(new byte[]{1, 2, 3, 4, 5})
//                .build();
//
//    }
//
//    @Test
//    public void ProductService_createProduct_ReturnProduct(){
//        //
//
//        when(productRepo.save(any(Product.class))).thenReturn(product);
//
//        ProductDto createdProduct = productServiceImp.createProduct(productDto);
//
//
//        ///  assert
//        assertThat(createdProduct).isNotNull();
//        //assertThat(product).isEqualTo(createdProduct);
//        assertThat(createdProduct.getProductName()).isEqualTo(product.getProductName());
//
//    }
//
//
//@Test
//    public void ProductService_getAllProducts_ReturnAllProducts(){
////        //Arrange
////List<Product> products = new ArrayList<>();
////        products.add(product);
////        products.add(Product.builder()
////                .productName("product2")
////                .price("1000")
////                .description("description2")
////                .quantity("10")
////                .image(new byte[]{6, 7, 8, 9, 10})
////                .build());
////        List<Product> savedProducts = productRepo.saveAll(products);
////
//
//
//        when(productRepo.findAll()).thenReturn(List.of(product));
//        //Act
//
//
//        List<ProductDto> allProducts=productServiceImp.getAllProducts();
//
//        //Assert
//
//        assertThat(allProducts).isNotNull();
//        assertThat(allProducts.size()).isEqualTo(1);
//
//
//    }
//    @Test
//public void ProductService_getProductById_ReturnProduct(){
//        //arrange
//    when(productRepo.findById(product.getId())).thenReturn(Optional.of(product));
//        //act
//    ProductDto productDto=productServiceImp.getProductById(product.getId());
//        //assert
//    assertThat(productDto).isNotNull();
//    assertThat(productDto.getProductName()).isEqualTo(product.getProductName());
//
//}
//@Test
/////
//    public void UpdateProduct_ReturnUpdatedProduct(){
//    when(productRepo.save(any(Product.class))).thenReturn(product);
//    when(productRepo.findById(product.getId())).thenReturn(Optional.of(product));
//
//    ///
//        ProductDto updatedProductDto=productServiceImp.updateProduct(product.getId(), productDto);
//
//    //assert
//    assertThat(updatedProductDto).isNotNull();
//
//    }
//
//    @Test
//    public void ProductService_DelelteProduct_ReturnDeletedProduct() {
////        when(productRepo.findById(product.getId())).thenReturn(Optional.of(product));
////      // productServiceImp.deleteProduct(product.getId());
////        productServiceImp.deleteProduct(product.getId());
////        assertThat(productRepo.findById(product.getId())).isEmpty();
////    }
//
//
//        when(productRepo.findById(product.getId())).thenReturn(Optional.of(product));
//
//assertAll(()->productRepo.deleteById(product.getId()));
//assertAll(()-> productServiceImp.deleteProduct(product.getId()));
//
//
//    }
//}
