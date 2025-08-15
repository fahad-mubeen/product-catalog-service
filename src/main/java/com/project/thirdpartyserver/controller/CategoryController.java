package com.project.thirdpartyserver.controller;

import com.project.thirdpartyserver.dto.AllProductsOfCategoryDTO;
import com.project.thirdpartyserver.dto.CategoryDTO;
import com.project.thirdpartyserver.exception.CategoryNotFoundException;
import com.project.thirdpartyserver.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categoryDTOList = this.categoryService.getAllCategories();
        if (categoryDTOList == null || categoryDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categoryDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        CategoryDTO categoryDTO = this.categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<AllProductsOfCategoryDTO> getAllProductsOfCategory(@PathVariable Long id) {
        AllProductsOfCategoryDTO allProductsOfCategoryDTO = this.categoryService.getAllProductsOfCategory(id);
        if (allProductsOfCategoryDTO == null) {
            throw new RuntimeException("Category not found with ID: " + id);
        }
        return ResponseEntity.ok(allProductsOfCategoryDTO);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        if (categoryDTO == null || categoryDTO.getName() == null) {
            return ResponseEntity.badRequest().build();
        }

        CategoryDTO createdCategory = this.categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(201).body(createdCategory);
    }
}
