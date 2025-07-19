//package com.example.tryshop;
//
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/api/**")
//                .allowedOrigins("http://localhost:5173") // Adjust the origin as needed
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "PaTCH")
//                .allowedHeaders("*")
//                .allowCredentials(true);
//    }
//}
