package com.project.thirdpartyserver.controller;

import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    ResponseEntity<List<ProductDTO>> getAllProducts() throws IOException {

        List<ProductDTO> productDTOList = this.productService.getAllProducts();
        if(productDTOList == null) {
            return ResponseEntity.notFound().build();
        }
        if(productDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productDTOList);
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws IOException {
        ProductDTO productDTO = this.productService.getProductById(id);
        if(productDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDTO);
    }
}
