package com.project.thirdpartyserver.controller;

import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<ProductDTO> getAllProducts() throws IOException {
        return this.productService.getAllProducts();
    }
}
