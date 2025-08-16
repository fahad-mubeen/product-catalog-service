package com.project.ProductCatalogService.service;

import com.project.ProductCatalogService.dto.AllProductsOfCategoryDTO;
import com.project.ProductCatalogService.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long id);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId);

    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    List<CategoryDTO> searchCategoriesByName(String name);

    boolean existsById(Long id);

    CategoryDTO findByName(String name);

    CategoryDTO deleteCategoryById(Long id);

    CategoryDTO deleteCategoryByName(String name);
}
