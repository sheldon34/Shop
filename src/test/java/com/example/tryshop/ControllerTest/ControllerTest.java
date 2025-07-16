//package com.example.tryshop.ControllerTest;
//
//import com.example.tryshop.Dto.ProductDto;
//import com.example.tryshop.Entity.Product;
//import com.example.tryshop.Repo.ProductRepo;
//import com.example.tryshop.Service.ProductService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static java.util.Optional.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//@Slf4j
//@WebMvcTest(Controller.class)
//@AutoConfigureMockMvc(addFilters = false)
//
//public class ControllerTest {
//
//    @MockitoBean
//    private ProductService productService;
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private Product product;
//
//    private ProductDto productDto;
//    @Autowired
//    private ProductRepo productRepo;
//
//    ///  initialize the test data here
//    @BeforeEach
//    public void init(){
//        product =Product.builder()
//                .id(1L)
//                .productName("productName")
//                .price("2121311")
//                .description("description")
//                .quantity("quantity")
//                .image(new byte[]{1, 2, 3, 4, 5})
//
//                .build();
//        product=new Product();
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
//
//@Test
//    public void ProductController_CreateProduct_ReturnProduct() throws Exception {
//     // seting the behavour of the mock service
//    given(productService.createProduct(ArgumentMatchers.any())).willAnswer(invocations->invocations.getArgument(0));
//
////ResultActions response=mockMvc.perform(post("/api/product/upload")
////                .contentType(MediaType.APPLICATION_JSON)
////        .content(objectMapper.writeValueAsString(productDto)));
//
//
//    ResultActions response = mockMvc.perform(post("/api/product/upload")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(objectMapper.writeValueAsString(productDto)));
//
//    // assert the response
//     response.andExpect(MockMvcResultMatchers.status().isCreated())
//             .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("productName"));
//        response.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("2121311"))
//                .andDo(MockMvcResultHandlers.print());
//    }
//   // @Test
////public  void ProductController_GetAllproducts_ReturnListOfProducts() throws Exception {
//// List<ProductDto> products= new ArrayList<>();
//// products.add(productDto);
//// products.add(
////         productDto.builder()
////                 //.id(2l)
////                    .productName("product2")
////                    .price("123456")
////                    .description("description2")
////                    .quantity("20")
////                 .Image(new byte[]{6, 7, 8, 9, 10})
////
////                 .build()
//// );
////
//// when(productService.getAllProducts()).thenReturn(products);
////
//// ResultActions response=mockMvc.perform(get("/api/product/getAll")
////         .contentType(MediaType.APPLICATION_JSON)
////         //.content(objectMapper.writeValueAsString(products))
////
//// );
////
//// response.andExpect(MockMvcResultMatchers.status().isOk())
////         .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
////         .andDo(MockMvcResultHandlers.print());
////
////
////
////}
//
////@Test
////    public void ProductController_DeleteProduct_ReturnProduct() throws Exception {
////        Long id=product.getId();
////        when(productService.getProductById(id)).thenReturn(Optional.of(product));
////
////        ResultActions response=mockMvc.perform(get("/api/product/getById/1")
////                .contentType(MediaType.APPLICATION_JSON)
////                .content(objectMapper.writeValueAsString(product)));
////
////
////        //Assering
////    response.andExpect(MockMvcResultMatchers.status().isOk())
////            .andDo(MockMvcResultHandlers.print())
////            .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("productName"));
////
////       // when(productService.getProductById(id)).thenReturn(Optional.of (product));
////    }
//
//@Test
//    public void ProductController_GetByProductById_ReturnProduct() throws Exception {
//        Long id =product.getId();
//        when(productService.getProductById(id)).thenReturn(productDto);
//        ResultActions  response=mockMvc.perform(get("/api/product/"+id)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(productDto)));
//
//
//        response.andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("productName"));
//
//                 ;
//
//
//    }
//    }
////}
