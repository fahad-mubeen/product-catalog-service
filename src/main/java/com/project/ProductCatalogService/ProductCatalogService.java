package com.project.ProductCatalogService;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
//@EnableDiscoveryClient
@SpringBootApplication
public class ProductCatalogService {

    public static void main(String[] args) {

        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(ProductCatalogService.class, args);
    }

}
