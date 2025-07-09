package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.AllProductsOfCategoryDTO;
import com.project.thirdpartyserver.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long id);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId);
}
