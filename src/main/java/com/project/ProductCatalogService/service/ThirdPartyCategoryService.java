package com.project.ProductCatalogService.service;

import com.project.ProductCatalogService.dto.AllProductsOfCategoryDTO;
import com.project.ProductCatalogService.dto.CategoryDTO;
import com.project.ProductCatalogService.gateway.ICategoryGateway;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(name = "category-service.type", havingValue = "third-party")
public class ThirdPartyCategoryService implements ICategoryService {
    private final ICategoryGateway categoryGateway;
    public ThirdPartyCategoryService(ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() {
        return this.categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return null;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) {
        return null;
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public List<CategoryDTO> searchCategoriesByName(String name) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public CategoryDTO findByName(String name) {
        return null;
    }

    @Override
    public CategoryDTO deleteCategoryById(Long id) {
        return null;
    }

    @Override
    public CategoryDTO deleteCategoryByName(String name) {
        return null;
    }
}
