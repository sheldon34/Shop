package com.example.tryshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example")
@ComponentScan(basePackages = "com.example.tryshop.controller" +" com.example.tryshop.service")
public class TryshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(TryshopApplication.class, args);
    }

}
