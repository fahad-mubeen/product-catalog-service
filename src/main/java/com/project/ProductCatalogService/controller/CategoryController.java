package com.project.ProductCatalogService.controller;

import com.project.ProductCatalogService.dto.AllProductsOfCategoryDTO;
import com.project.ProductCatalogService.dto.CategoryDTO;
import com.project.ProductCatalogService.service.ICategoryService;
import jakarta.validation.Valid;
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

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody @Valid CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok(updatedCategory);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoryDTO>> searchCategoriesByName(@RequestParam String name) {
        List<CategoryDTO> categoryDTO = categoryService.searchCategoriesByName(name);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/name")
    public ResponseEntity<CategoryDTO> getCategoryByName(@RequestParam("categoryname") String name) {
        CategoryDTO categoryDTO = categoryService.findByName(name);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.existsById(id));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<CategoryDTO> deleteCategoryById(@PathVariable Long id) {
        CategoryDTO deletedCategory = categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(deletedCategory);
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<CategoryDTO> deleteCategoryByName(@PathVariable String name) {
        CategoryDTO deletedCategory = categoryService.deleteCategoryByName(name);
        return ResponseEntity.ok(deletedCategory);
    }
}
