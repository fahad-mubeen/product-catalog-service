package com.project.thirdpartyserver.controller;

import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.dto.ProductWithCategory_DTO;
import com.project.thirdpartyserver.service.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;
    public ProductController(@Qualifier("productService") IProductService productService) {
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

    @GetMapping("/{id}/with-category")
    ResponseEntity<ProductWithCategory_DTO> getProductWithCategoryById(@PathVariable Long id) throws IOException {
        ProductWithCategory_DTO productWithCategoryDTO = this.productService.getProductWithCategoryById(id);
        if (productWithCategoryDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productWithCategoryDTO);
    }

    @PostMapping
    ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) throws IOException {
        if (productDTO == null || productDTO.getName() == null || productDTO.getCategoryId() == null) {
            return ResponseEntity.badRequest().build();
        }

        ProductDTO createdProduct = this.productService.createProduct(productDTO);
        return ResponseEntity.status(201).body(createdProduct);
    }
}
