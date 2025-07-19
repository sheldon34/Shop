package com.example.tryshop;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
@Component
public class CorsConfig implements CorsConfigurationSource {


    @Override
    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("*"
                //"http://localhost:5173"
        ));
        config.setAllowedMethods(List.of("GET","POST","PATCH","PUT","DELETE"));
        config.setAllowedHeaders(List.of("*"));
        // Adjust the origin as needed
        return config;
    }
}